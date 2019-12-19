package com.lcl.demo.sbDemo.entity;

public class UserNoteKey {
    private Long id;

    private Long userId;

    private Long noteId;

    public UserNoteKey(Long id, Long userId, Long noteId) {
        this.id = id;
        this.userId = userId;
        this.noteId = noteId;
    }

    public UserNoteKey() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }
}