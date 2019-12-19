package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Long noteId);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Long noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}