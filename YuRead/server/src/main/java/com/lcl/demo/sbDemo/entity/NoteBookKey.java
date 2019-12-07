package com.lcl.demo.sbDemo.entity;

public class NoteBookKey {
    private Integer noteId;

    private Integer bookId;

    public NoteBookKey(Integer noteId, Integer bookId) {
        this.noteId = noteId;
        this.bookId = bookId;
    }

    public NoteBookKey() {
        super();
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}