package com.littleboard.service.impl;

import com.littleboard.common.ServerResponse;
import com.littleboard.dao.MemberMapper;
import com.littleboard.dao.ProjectMapper;
import com.littleboard.pojo.Member;
import com.littleboard.pojo.Project;
import com.littleboard.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iMemberService")
public class MemberServiceImpl implements IMemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ServerResponse addMembers(Integer userId, Integer projectId, List<Integer> memberIds) {
        Project project = projectMapper.selectByPrimaryKeyAndOwnerId(projectId, userId);
        if(project == null) {
            return ServerResponse.createByErrorMessage("当前用户非项目组组长, 无法添加项目成员");
        }
        for(Integer memberId : memberIds) {
            Member tempMember = memberMapper.selectByProjectIdAndUserId(projectId, memberId);
            if(tempMember != null) {
                continue;
            }
            Member member = new Member();
            member.setpId(projectId);
            member.setuId(memberId);
            member.setOwner(userId);
            member.setRole(null);
            int resultCount = memberMapper.insert(member);
            if(resultCount == 0) {
                //添加事务, 如果在添加数据库的过程中发生错误, 回滚到添加之前
                return ServerResponse.createByErrorMessage("添加失败");
            }
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse getMembers(Integer userId, Integer projectId) {
        Member member = memberMapper.selectByProjectIdAndUserId(projectId, userId);
        if(member == null) {
            return ServerResponse.createByErrorMessage("当前用户非此项目组成员, 无法查看项目成员列表");
        }
        List<Member> members = memberMapper.selectByProjectId(projectId);
        if(members == null) {
            return ServerResponse.createBySuccessMessage("当前项目组暂无成员");
        }
        return ServerResponse.createBySuccess(members);
    }

    @Override
    public ServerResponse deleteMember(Integer userId, Integer projectId, Integer memberId) {
        Project project = projectMapper.selectByPrimaryKeyAndOwnerId(projectId, userId);
        if(project == null) {
            return ServerResponse.createByErrorMessage("当前用户非项目组组长, 无法删除项目成员");
        }
        int resultCount = memberMapper.deleteByProjectIdAndUserId(projectId, memberId);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse modifyMember(Integer userId, Integer projectId, Integer memberId, Member member) {
        Project project = projectMapper.selectByPrimaryKeyAndOwnerId(projectId, userId);
        if(project == null) {
            return ServerResponse.createByErrorMessage("当前用户非项目组组长, 无法修改项目成员");
        }
        Member m = memberMapper.selectByProjectIdAndUserId(projectId, memberId);
        if(m == null) {
            return ServerResponse.createByErrorMessage("当前项目组没有此项目成员, 无法修改");
        }
        if(member.getRole() != null) {
            m.setRole(member.getRole());
        }
        int resultCount = memberMapper.updateByPrimaryKeySelective(m);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createBySuccessMessage("修改成功");
    }
}
