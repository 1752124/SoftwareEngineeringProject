package com.lcl.demo.sbDemo.dao;


import com.lcl.demo.sbDemo.entity.Booklist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BooklistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Booklist record);

    int insertSelective(Booklist record);

    List<Booklist> selectByPrimaryKey(@Param("type") Byte type);

    int updateByPrimaryKeySelective(Booklist record);

    int updateByPrimaryKey(Booklist record);
}