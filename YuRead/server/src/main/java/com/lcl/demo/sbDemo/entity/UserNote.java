package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class UserNote extends UserNoteKey {
    private Date createTime;

    private Date updateTime;

    public UserNote(Long id, Long userId, Long noteId, Date createTime, Date updateTime) {
        super(id, userId, noteId);
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserNote() {
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
}