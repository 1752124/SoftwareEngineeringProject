package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(@Param("userId") Long userId);

    int updateNameById(@Param("userId") Long id, @Param("name") String name );

    int updatePortraitById(@Param("userId") Long id, @Param("portrait") String portrait );

    User selectByPrimaryKey(@Param("userId") Long userId);

    List<User> select();

}