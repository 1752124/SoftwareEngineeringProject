package com.lcl.demo.sbDemo.dao;


import com.lcl.demo.sbDemo.entity.Booklist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BooklistMapper {
    int delete(@Param("id") Long id);

    int insert(@Param("id") Long id,@Param("title") String title,@Param("author") String author,@Param("image") String image,@Param("type") Byte type,@Param("summary") String summary,@Param("publisher") String publisher,@Param("ranking") String ranking,@Param("category") String category);

    List<Booklist> select();

    List<Booklist> selectByPrimaryKey(@Param("type") Byte type);

    int update(@Param("id") Long id,@Param("title") String title,@Param("author") String author,@Param("image") String image,@Param("type") Byte type,@Param("summary") String summary,@Param("publisher") String publisher,@Param("ranking") String ranking,@Param("category") String category);


}