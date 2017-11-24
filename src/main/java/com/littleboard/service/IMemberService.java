package com.littleboard.service;

import com.littleboard.common.ServerResponse;
import com.littleboard.pojo.Member;

import java.util.List;

public interface IMemberService {
    ServerResponse addMembers(Integer userId, Integer projectId, List<Integer> memberIds);

    ServerResponse getMembers(Integer userId, Integer projectId);

    ServerResponse deleteMember(Integer userId, Integer projectId, Integer memberId);

    ServerResponse modifyMember(Integer userId, Integer projectId, Integer memberId, Member member);
}

