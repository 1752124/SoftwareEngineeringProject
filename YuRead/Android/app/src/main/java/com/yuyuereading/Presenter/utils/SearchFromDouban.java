package com.yuyuereading.Presenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.Model.bean.BookInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.amap.api.mapcore2d.q.i;

public class SearchFromDouban {
    /**
     * 解析豆瓣搜索的数据
     * 工具类
     * 传入值：json字符串
     * 返回值：List<BookInfo>类
     */
    public static List<BookInfo> parsingBookInfos(final JSONArray jsonArray) throws IOException {
        List<BookInfo> bookInfos = new ArrayList<>();
//        int count = jsonObject.getInteger( "count");
//        int start =jsonObject.getInteger("start");
        //int total =jsonObject.getInteger("total");
        //JSONArray books= jsonObject.getJSONArray("body");
        for(i=0;i<jsonArray.size();i++){
            BookInfo bookInfo;
            bookInfo= BookInfoGetFromDouban.parsingBookInfo(jsonArray.get(i).toString());
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
