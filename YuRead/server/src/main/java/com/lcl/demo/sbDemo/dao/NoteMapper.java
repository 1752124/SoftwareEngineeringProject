package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Not;

import java.util.List;

@Mapper
public interface NoteMapper {
    int deleteByPrimaryKey(Long noteId);

    int insert(Note note);

    List<Note> select(@Param("userId") Long userId, @Param("bookId") Long bookId);

    int update(@Param("noteId") Long noteId, @Param("content") String content);

    int delete(@Param("noteId") Long noteId);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Long noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}