package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Book extends BookKey {
    private String title;

    private String author;

    private String image;

    private Date updateTime;

    public Book(Long bookId, Date createTime, String title, String author, String image, Date updateTime) {
        super(bookId, createTime);
        this.title = title;
        this.author = author;
        this.image = image;
        this.updateTime = updateTime;
    }

    public Book() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}