package com.littleboard.pojo;

import java.util.Date;

public class Task {
    private Integer id;

    private Integer pId;

    private String title;

    private Date createTime;

    private Integer creator;

    private String worker;

    private Integer status;

    private String tags;

    private String description;

    public Task(Integer id, Integer pId, String title, Date createTime, Integer creator, String worker, Integer status, String tags, String description) {
        this.id = id;
        this.pId = pId;
        this.title = title;
        this.createTime = createTime;
        this.creator = creator;
        this.worker = worker;
        this.status = status;
        this.tags = tags;
        this.description = description;
    }

    public Task() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker == null ? null : worker.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}