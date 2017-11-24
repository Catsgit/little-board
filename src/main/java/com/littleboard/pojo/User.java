package com.littleboard.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private Integer uId;

    private String name;

    private String password;

    private Date createTime;

    private Integer phoneNumber;

    private String email;

    public User(Integer id, Integer uId, String name, String password, Date createTime, Integer phoneNumber, String email) {
        this.id = id;
        this.uId = uId;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}