package com.littleboard.pojo;

import java.util.Date;

public class Todo {
    private Integer id;

    private Integer taskId;

    private Integer status;

    private Integer owner;

    private Date createTime;

    public Todo(Integer id, Integer taskId, Integer status, Integer owner, Date createTime) {
        this.id = id;
        this.taskId = taskId;
        this.status = status;
        this.owner = owner;
        this.createTime = createTime;
    }

    public Todo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}