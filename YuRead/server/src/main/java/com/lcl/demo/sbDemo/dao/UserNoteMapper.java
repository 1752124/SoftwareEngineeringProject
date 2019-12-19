package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.UserNote;
import com.lcl.demo.sbDemo.entity.UserNoteKey;

public interface UserNoteMapper {
    int deleteByPrimaryKey(UserNoteKey key);

    int insert(UserNote record);

    int insertSelective(UserNote record);

    UserNote selectByPrimaryKey(UserNoteKey key);

    int updateByPrimaryKeySelective(UserNote record);

    int updateByPrimaryKey(UserNote record);
}