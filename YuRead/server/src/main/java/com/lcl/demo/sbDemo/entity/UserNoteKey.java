package com.lcl.demo.sbDemo.entity;

public class UserNoteKey {
    private Integer userId;

    private Integer noteId;

    public UserNoteKey(Integer userId, Integer noteId) {
        this.userId = userId;
        this.noteId = noteId;
    }

    public UserNoteKey() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }
}