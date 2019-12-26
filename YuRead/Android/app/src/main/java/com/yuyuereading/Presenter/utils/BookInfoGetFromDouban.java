package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookInfo;

import java.io.IOException;

public class BookInfoGetFromDouban {

    //解析从豆瓣服务器获取相应的图书信息JSON
    public static BookInfo parsingBookInfo(final String json) throws IOException {
        //解析从api传回来的json数据
        BookInfo bookInfo = new BookInfo();
        JSONObject bookItem = JSON.parseObject(json);

        String bookName=bookItem.getString("title");
        bookInfo.setBook_name(bookName);
        String image=bookItem.getString("image");
        bookInfo.setBook_image(image);
        String author = bookItem.getString("author");
        bookInfo.setBook_author(author);
        String summary = bookItem.getString("summary");
        bookInfo.setBook_summary(summary);
      //  String isbn10 = bookItem.getString("isbn10");
        //bookInfo.setBook_isbn10(isbn10);
       // String isbn13 = bookItem.getString("isbn13");
       // bookInfo.setBook_isbn13(isbn13);
        String publisher = bookItem.getString("publisher");
        bookInfo.setBook_publisher(publisher);
        //获取豆瓣平均评分
        String rating =bookItem.getString("ranking");
        bookInfo.setBook_rating(rating);

        return bookInfo;
    }
}
