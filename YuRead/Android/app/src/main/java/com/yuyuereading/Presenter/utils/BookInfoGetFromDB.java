package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookInfo;

import java.io.IOException;

public class BookInfoGetFromDB {

    //解析从豆瓣服务器获取相应的图书信息JSON
    public static BookInfo parsingBookInfo(final String json) throws IOException {
        //解析从api传回来的json数据
        BookInfo bookInfo = new BookInfo();
        JSONObject bookItem = JSON.parseObject(json);

        String bookISBN=bookItem.getString("bookId");
        bookInfo.setBook_isbn13(bookISBN);
        String bookName=bookItem.getString("title");
        bookInfo.setBook_name(bookName);
        String image=bookItem.getString("image");
        if(image == null){image="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2039366680,214296142&fm=26&gp=0.jpg";}
        bookInfo.setBook_image(image);
        String author = bookItem.getString("author");
        bookInfo.setBook_author(author);
        String summary = bookItem.getString("summary");
        if (summary==null){summary="暂无简介";}
        bookInfo.setBook_summary(summary);
        String publisher = bookItem.getString("publisher");
        bookInfo.setBook_publisher(publisher);
        //获取豆瓣平均评分
        String rating =bookItem.getString("ranking");
        bookInfo.setBook_rating(rating);

        return bookInfo;
    }
}
