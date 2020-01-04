package com.yuyuereading.presenter.utils;

import com.alibaba.fastjson.JSONArray;
import com.yuyuereading.model.bean.BookInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.amap.api.mapcore2d.q.i;

public class SearchFromDouban {
    /**
     * 解析数据库搜索的数据
     * 工具类
     * 传入值：json字符串
     * 返回值：List<BookInfo>类
     */
    public static List<BookInfo> parsingBookInfo(final JSONArray jsonArray) throws IOException {
        List<BookInfo> bookInfos = new ArrayList<>();
        for(i=0;i<jsonArray.size();i++){
            BookInfo bookInfo;
            bookInfo= BookInfoGetFromDB.parsingBookInfo(jsonArray.get(i).toString());
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }

    /**
     * 解析数据库搜索的数据
     * 工具类
     * 传入值：json字符串
     * 返回值：List<BookInfo>类
     */
    public static List<BookInfo> parsingBookInfoDouBan(final JSONArray jsonArray) throws IOException {
        List<BookInfo> bookInfos = new ArrayList<>();
        for(i=0;i<jsonArray.size();i++){
            BookInfo bookInfo;
            bookInfo= BookInfoGetFromDouBan.parsingBookInfo(jsonArray.get(i).toString());
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
