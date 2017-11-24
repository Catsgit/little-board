package com.littleboard.service;

import com.littleboard.common.ServerResponse;
import com.littleboard.pojo.Project;

import java.util.List;

public interface IProjectService {
    ServerResponse createProject(Integer userId, Project project);
    ServerResponse getAllProjects(Integer userId);
    ServerResponse getProjectById(Integer userId, Integer id);
    ServerResponse deleteProject(Integer userId, Integer id);
    ServerResponse modifyProject(Integer userId, Integer id, Project project);
}
