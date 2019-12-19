package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class BookKey {
    private Long bookId;

    private Date createTime;

    public BookKey(Long bookId, Date createTime) {
        this.bookId = bookId;
        this.createTime = createTime;
    }

    public BookKey() {
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}