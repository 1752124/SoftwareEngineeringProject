package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Note {
    private Long userId;

    private Long bookId;

    private Date date;

    private Integer beginPage;

    private Integer endPage;

    private String content;

    private Date createTime;

    private Date updateTime;

    public Note(Long userId, Long bookId, Date date, Integer beginPage, Integer endPage, String content, Date createTime, Date updateTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.date = date;
        this.beginPage = beginPage;
        this.endPage = endPage;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Note() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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