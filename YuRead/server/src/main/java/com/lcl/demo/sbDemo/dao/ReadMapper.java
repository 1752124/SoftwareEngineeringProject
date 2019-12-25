package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Read;
import com.lcl.demo.sbDemo.entity.ReadKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReadMapper {
    int deleteByPrimaryKey(ReadKey key);

    int insert(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("state") Integer state);

    int update(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("state") Integer state);

    List<Read> select(@Param("userId") Long userId, @Param("state") Integer state);

    List<Read> selectByLikeTitle(@Param("keyword") String  keyword);

    Read selectByPrimaryKey(Long bookId);

    int insertSelective(Read record);

    Read selectByPrimaryKey(ReadKey key);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);
}