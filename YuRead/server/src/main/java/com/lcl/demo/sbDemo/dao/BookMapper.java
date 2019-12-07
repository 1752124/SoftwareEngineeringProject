package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Book;
import com.lcl.demo.sbDemo.entity.BookKey;

public interface BookMapper {
    int deleteByPrimaryKey(BookKey key);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(BookKey key);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}