package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Read {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Integer state;

    private Date date;

    private Date createTime;

    private Date updateTime;

    public Read(Integer id, Integer userId, Integer bookId, Integer state, Date date, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.state = state;
        this.date = date;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Read() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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