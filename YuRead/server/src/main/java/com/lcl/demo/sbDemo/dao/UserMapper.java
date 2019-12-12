package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.User;
import com.lcl.demo.sbDemo.entity.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(String user);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(String user);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}