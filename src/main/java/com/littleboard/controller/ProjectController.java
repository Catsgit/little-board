package com.littleboard.controller;

import com.littleboard.common.Const;
import com.littleboard.common.ResponseCode;
import com.littleboard.common.ServerResponse;
import com.littleboard.pojo.Project;
import com.littleboard.pojo.User;
import com.littleboard.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    @RequestMapping(value = "projects", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse createProject(HttpSession session, @RequestParam("project") Project project) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iProjectService.createProject(user.getId(), project);
    }

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getProjectList(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iProjectService.getAllProjects(user.getId());
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getProject(HttpSession session, @PathVariable("id") Integer id) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iProjectService.getProjectById(user.getId(), id);
    }

    @RequestMapping(value = "projects/{deleteid}", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteProject(HttpSession session, @PathVariable("deleteid") Integer id) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iProjectService.deleteProject(user.getId(), id);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse modifyProject(HttpSession session, @PathVariable("id") Integer id, @RequestParam("project") Project project) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iProjectService.modifyProject(user.getId(), id, project);
    }
}
