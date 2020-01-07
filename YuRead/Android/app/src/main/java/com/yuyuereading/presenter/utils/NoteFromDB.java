package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookComment;

import java.io.IOException;

public class NoteFromDB {
    public static BookComment parsingBookNote(final String json) throws IOException {
        //解析从api传回来的json数据
        BookComment bookComment = new BookComment();
        JSONObject bookItem = JSON.parseObject(json);

        String begin=bookItem.getString("beginPage");
        String end=bookItem.getString("endPage");
        bookComment.setPage_update(begin+"-"+end);
        String noteid=bookItem.getString("noteId");
        bookComment.setNoteID(Integer.parseInt(noteid));
        String content=bookItem.getString("content");
        if(content == null){content="无";}
        bookComment.setRead_review(content);
        String date = bookItem.getString("date");
        bookComment.setFinish_time(date.substring(0,10));
        return bookComment;
    }
}
