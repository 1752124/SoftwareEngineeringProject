package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Booklist {
    private Long id;

    private String author;

    private String title;

    private String image;

    private Byte type;

    private Date createTime;

    private Date updateTime;

    private String category;

    public Booklist(Long id, String author, String title, String image, Byte type, Date createTime, Date updateTime, String category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.image = image;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public Booklist() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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