package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Read extends ReadKey {
    private Date createTime;

    private Date updateTime;

    private Integer state;

    public Read(Long id, Long bookId, Long userId, Date createTime, Date updateTime, Integer state) {
        super(id, bookId, userId);
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.state = state;
    }

    public Read() {
        super();
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}