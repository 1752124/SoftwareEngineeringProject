package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Statistic {
    private Long userId;

    private Integer sumBook;

    private Integer sumRead;

    private Integer sumDay;

    private Integer sumNote;

    private Date createTime;

    private Date updateTime;

    public Statistic(Long userId, Integer sumBook, Integer sumRead, Integer sumDay, Integer sumNote, Date createTime, Date updateTime) {
        this.userId = userId;
        this.sumBook = sumBook;
        this.sumRead = sumRead;
        this.sumDay = sumDay;
        this.sumNote = sumNote;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Statistic() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSumBook() {
        return sumBook;
    }

    public void setSumBook(Integer sumBook) {
        this.sumBook = sumBook;
    }

    public Integer getSumRead() {
        return sumRead;
    }

    public void setSumRead(Integer sumRead) {
        this.sumRead = sumRead;
    }

    public Integer getSumDay() {
        return sumDay;
    }

    public void setSumDay(Integer sumDay) {
        this.sumDay = sumDay;
    }

    public Integer getSumNote() {
        return sumNote;
    }

    public void setSumNote(Integer sumNote) {
        this.sumNote = sumNote;
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