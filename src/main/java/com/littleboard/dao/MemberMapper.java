package com.littleboard.dao;

import com.littleboard.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    int insert(Member record);

    int insertSelective(Member record);

    Member selectByProjectIdAndUserId(@Param(value = "projectId") Integer projectId, @Param(value = "userId") Integer userId);

    List<Member> selectByProjectId(@Param(value = "projectId") Integer projectId);

    int deleteByProjectIdAndUserId(@Param(value = "projectId") Integer projectId, @Param(value = "userId") Integer userId);

    int updateByPrimaryKeySelective(@Param(value = "member") Member member);
}