package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSONArray;
import com.yuyuereading.model.bean.BookComment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.amap.api.mapcore2d.q.i;

public class NoteGetFromDB {
    public static List<BookComment> parsingBookCom(final JSONArray jsonArray) throws IOException {
        List<BookComment> bookComments = new ArrayList<>();
        for(i=0;i<jsonArray.size();i++){
            BookComment bookComment;
            bookComment= NoteFromDB.parsingBookNote(jsonArray.get(i).toString());
            bookComments.add(bookComment);
        }
        return bookComments;
    }
}