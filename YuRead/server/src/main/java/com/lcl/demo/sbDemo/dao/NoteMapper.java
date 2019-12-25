package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteMapper {
    int deleteByPrimaryKey(Long noteId);

    int insert(@Param("userId") Long userId, @Param("bookId") Long bookId, @Param("beginPage") Integer beginPage, @Param("endPage") Integer endPage, @Param("content") String content);

    List<Note> select(@Param("userId") Long userId, @Param("bookId") Long bookId);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Long noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}