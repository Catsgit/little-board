package com.littleboard.service.impl;

import com.littleboard.common.ServerResponse;
import com.littleboard.dao.ProjectMapper;
import com.littleboard.pojo.Project;
import com.littleboard.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iProjectService")
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ServerResponse createProject(Integer userId, Project project) {
        project.setOwner(userId);
        project.setWorker("userId");
        int resultCount = projectMapper.insert(project);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("创建失败");
        }
        return ServerResponse.createBySuccessMessage("创建成功");
    }

    @Override
    public ServerResponse getAllProjects(Integer userId) {
        List<Project> projects = projectMapper.getAllProjectByOwnerId(userId);
        if(projects == null) {
            return ServerResponse.createBySuccessMessage("当前无项目");
        }
        return ServerResponse.createBySuccess(projects);
    }

    @Override
    public ServerResponse getProjectById(Integer userId, Integer id) {
        Project project = projectMapper.selectByPrimaryKeyAndOwnerId(id, userId);
        if(project == null) {
            return ServerResponse.createByErrorMessage("用户没有此项目");
        }
        return ServerResponse.createBySuccess(project);
    }

    @Override
    public ServerResponse deleteProject(Integer userId, Integer id) {
        int resultCount = projectMapper.deleteByPrimaryKeyAndOwnerId(id, userId);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("当前用户无此项目, 无法删除");
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse modifyProject(Integer userId, Integer id, Project project) {
        Project p = projectMapper.selectByPrimaryKeyAndOwnerId(id, userId);
        if(p == null) {
            return ServerResponse.createByErrorMessage("当前用户无此项目, 无法修改");
        }
        if(project.getName() != null) {
            p.setName(project.getName());
        }
        if(project.getDescription() != null) {
            p.setDescription(project.getDescription());
        }
        if(project.getType() != null) {
            p.setType(project.getType());
        }
        int resultCount = projectMapper.updateByPrimaryKeySelective(p);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createBySuccessMessage("修改成功");
    }
}
