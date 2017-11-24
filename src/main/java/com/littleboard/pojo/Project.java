package com.littleboard.pojo;

import java.util.Date;

public class Project {
    private Integer id;

    private String name;

    private String description;

    private String type;

    private Date createTime;

    private Integer owner;

    private String worker;

    public Project(Integer id, String name, String description, String type, Date createTime, Integer owner, String worker) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.createTime = createTime;
        this.owner = owner;
        this.worker = worker;
    }

    public Project() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker == null ? null : worker.trim();
    }
}