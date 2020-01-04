package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookInfo;

import java.io.IOException;
public class BookInfoGetFromDouBan {

    //解析从豆瓣服务器获取相应的图书信息JSON
    public static BookInfo parsingBookInfo(final String json) throws IOException {
        //解析从豆瓣传回来的json数据
        BookInfo bookInfo = new BookInfo();
        JSONObject bookItem = JSON.parseObject(json);

        String bookName=bookItem.getString("title");
        bookInfo.setBook_name(bookName);
        JSONObject imagedt=JSON.parseObject(bookItem.getString("image"));
        String image=imagedt.getString("medium");
        bookInfo.setBook_image(image);
        //解析作者组
        JSONArray authors = bookItem.getJSONArray("author");
        StringBuilder book_author = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            book_author.append(" ").append(authors.get(i));
        }
        bookInfo.setBook_author(book_author.toString());

        String summary = bookItem.getString("summary");
        bookInfo.setBook_summary(summary);
        String isbn10 = bookItem.getString("isbn10");
        bookInfo.setBook_isbn10(isbn10);
        String isbn13 = bookItem.getString("isbn13");
        bookInfo.setBook_isbn13(isbn13);
        String publisher = bookItem.getString("publisher");
        bookInfo.setBook_publisher(publisher);
        //获取豆瓣平均评分
        JSONObject ratingdt=JSON.parseObject(bookItem.getString("rating"));
        String rating=ratingdt.getString("average");
        bookInfo.setBook_rating(rating);
        String pages = bookItem.getString("pages");
        bookInfo.setBook_pages(pages);
        //解析标签组
        JSONArray tags = bookItem.getJSONArray("tags");
        StringBuilder book_tags = new StringBuilder();
        for (int j = 0; j< tags.size(); j++) {
            JSONObject tagItem = JSON.parseObject(tags.get(j).toString());
            book_tags.append(" ").append(tagItem.getString("title"));
        }
        bookInfo.setBook_tags(book_tags.toString());

        return bookInfo;
    }
}