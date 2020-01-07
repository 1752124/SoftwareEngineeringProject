package com.yuyuereading.model.bean;

import java.io.Serializable;

public class BookComment implements Serializable {
    private String read_review;

    private  String page_update;

    private String finish_time;

    private long noteID;

    public BookComment(){    }

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

    public void setPage_update(String page_update){this.page_update=page_update;}

    public long getNoteID() {return noteID;}

    public void setNoteID(long noteID) {this.noteID = noteID;}
}
