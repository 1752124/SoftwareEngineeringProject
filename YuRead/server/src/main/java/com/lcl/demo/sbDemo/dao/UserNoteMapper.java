package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.UserNoteKey;

public interface UserNoteMapper {
    int deleteByPrimaryKey(UserNoteKey key);

    int insert(UserNoteKey record);

    int insertSelective(UserNoteKey record);
}