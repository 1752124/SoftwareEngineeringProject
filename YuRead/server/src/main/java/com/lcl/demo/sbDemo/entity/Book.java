package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Book {
    private Long bookId;

    private String title;

    private String author;

    private String image;

    private Date createTime;

    private Date updateTime;

    private String category;

    public Book(Long bookId, String title, String author, String image, Date createTime, Date updateTime, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Book() {
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}