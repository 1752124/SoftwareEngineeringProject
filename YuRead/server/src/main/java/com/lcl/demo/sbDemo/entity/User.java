package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class User {
    private Long userId;

    private String name;

    private Byte auth;

    private String portrait;

    private Date createTime;

    private Date updateTime;

    public User(Long userId, String name, Byte auth, String portrait, Date createTime, Date updateTime) {
        this.userId = userId;
        this.name = name;
        this.auth = auth;
        this.portrait = portrait;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAuth() {
        return auth;
    }

    public void setAuth(Byte auth) {
        this.auth = auth;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}