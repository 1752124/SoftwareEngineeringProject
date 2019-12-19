package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.NoteBook;
import com.lcl.demo.sbDemo.entity.NoteBookKey;

public interface NoteBookMapper {
    int deleteByPrimaryKey(NoteBookKey key);

    int insert(NoteBook record);

    int insertSelective(NoteBook record);

    NoteBook selectByPrimaryKey(NoteBookKey key);

    int updateByPrimaryKeySelective(NoteBook record);

    int updateByPrimaryKey(NoteBook record);
}