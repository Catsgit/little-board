package com.littleboard.pojo;

public class Tag {
    private Integer id;

    private Integer pId;

    private String name;

    private String color;

    public Tag(Integer id, Integer pId, String name, String color) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.color = color;
    }

    public Tag() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}