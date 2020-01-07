package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookInfo;

import java.io.IOException;

public class BookInfoGetFromPerson {
    public static BookInfo parsingBookInfo(final String json) throws IOException {
        //解析从api传回来的json数据
        BookInfo bookInfo = new BookInfo();
        JSONObject bookItem = JSON.parseObject(json);

        String bookName=bookItem.getString("title");
        bookInfo.setBook_name(bookName);
        String image=bookItem.getString("image");
        if(image == null){image="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2039366680,214296142&fm=26&gp=0.jpg";}
        bookInfo.setBook_image(image);

        return bookInfo;
    }
}