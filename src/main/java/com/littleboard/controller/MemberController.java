package com.littleboard.controller;

import com.littleboard.common.Const;
import com.littleboard.common.ResponseCode;
import com.littleboard.common.ServerResponse;
import com.littleboard.pojo.Member;
import com.littleboard.pojo.User;
import com.littleboard.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private IMemberService iMemberService;

    @RequestMapping(value = "projects/{pid}/members", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addMembers(HttpSession session, @PathVariable(value = "pid") Integer projectId, @RequestParam(value = "memberIds") List<Integer> memberIds) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iMemberService.addMembers(user.getId(), projectId, memberIds);
    }

    @RequestMapping(value = "projects/{pid}/members", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getMembers(HttpSession session, @PathVariable(value = "pid") Integer projectId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iMemberService.getMembers(user.getId(), projectId);
    }

    @RequestMapping(value = "projects/{pid}/members/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse deleteMember(HttpSession session, @PathVariable(value = "pid") Integer projectId, @PathVariable(value = "uid") Integer memberId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iMemberService.deleteMember(user.getId(), projectId, memberId);
    }

    @RequestMapping(value = "projects/{pid}/members/{uid}", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse modifyMember(HttpSession session, @PathVariable("pid") Integer projectId, @PathVariable("uid") Integer memberId, @RequestParam("member") Member member) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录, 请登录");
        }
        return iMemberService.modifyMember(user.getId(), projectId, memberId, member);
    }
}


