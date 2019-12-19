package com.yuyuereading.Model.bean;

import java.io.Serializable;

public class BookComment implements Serializable {
    private String read_review;

    private  String page_update;

    private String finish_time;

    public BookComment(String finish_time,String page_update,String read_review)
    {
       this.read_review=read_review;
       this.page_update=page_update;
       this.finish_time=finish_time;
    }
    public String getRead_review() {
        return read_review;
    }

    public void setRead_review(String read_review) {
        this.read_review = read_review;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getPage_update() {
        return page_update;
    }
}
