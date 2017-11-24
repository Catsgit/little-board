package com.littleboard.dao;

import com.littleboard.pojo.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> getAllProjectByOwnerId(@Param(value = "ownerId") Integer ownerId);

    Project selectByPrimaryKeyAndOwnerId(@Param(value = "id") Integer id, @Param(value = "ownerId") Integer ownerId);

    int deleteByPrimaryKeyAndOwnerId(@Param(value = "id") Integer id, @Param(value = "ownerId") Integer ownerId);
}