package com.littleboard.pojo;

import java.util.Date;

public class Member {
    private Integer pId;

    private Integer uId;

    private Date joinTime;

    private Integer owner;

    private Integer role;

    public Member(Integer pId, Integer uId, Date joinTime, Integer owner, Integer role) {
        this.pId = pId;
        this.uId = uId;
        this.joinTime = joinTime;
        this.owner = owner;
        this.role = role;
    }

    public Member() {
        super();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}