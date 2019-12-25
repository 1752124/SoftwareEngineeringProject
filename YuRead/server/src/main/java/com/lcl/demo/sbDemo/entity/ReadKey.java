package com.lcl.demo.sbDemo.entity;

public class ReadKey {

    private Long userId;

    private Long bookId;

    public ReadKey(Long bookId, Long userId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public ReadKey() {
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}