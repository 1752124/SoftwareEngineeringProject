package com.lcl.demo.sbDemo.entity;

import java.util.Date;

public class Booklist {
    private Long id;

    private String title;

    private String author;

    private String image;

    private Integer state;

    private Date createTime;

    private Date updateTime;

    public Booklist(Long id, String title, String author, String image, Integer state, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.state = state;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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