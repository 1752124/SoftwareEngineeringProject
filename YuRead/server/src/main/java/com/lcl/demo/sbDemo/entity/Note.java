package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Note {
    private Integer noteId;

    private String content;

    private Date date;

    private Integer beginPage;

    private Integer endPage;

    private Date createTime;

    private Date updateTime;

    public Note(Integer noteId, String content, Date date, Integer beginPage, Integer endPage, Date createTime, Date updateTime) {
        this.noteId = noteId;
        this.content = content;
        this.date = date;
        this.beginPage = beginPage;
        this.endPage = endPage;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Note() {
        super();
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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