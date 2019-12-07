package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Read;

public interface ReadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Read record);

    int insertSelective(Read record);

    Read selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);
}