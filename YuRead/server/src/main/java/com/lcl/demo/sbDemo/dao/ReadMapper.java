package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Read;
import com.lcl.demo.sbDemo.entity.ReadKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ReadMapper {
    int deleteByPrimaryKey(ReadKey key);

    int insert(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("state") Integer state, @Param("title") String title, @Param("author") String author, @Param("publisher") String publisher);

    int update(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("state") Integer state);

    List<Read> select(@Param("userId") Long userId, @Param("state") Integer state);

    List<Read> selectByLikeTitle(@Param("userId") Long userId, @Param("keyword") String  keyword);

    Read selectByPrimaryKey(@Param("userId") Long userId, @Param("bookId") Long bookId);

}