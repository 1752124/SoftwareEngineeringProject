package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Booklist;

public interface BooklistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Booklist record);

    int insertSelective(Booklist record);

    Booklist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Booklist record);

    int updateByPrimaryKey(Booklist record);
}