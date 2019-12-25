package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Long userId);

    int updateNameById(@Param("userId") Long id, @Param("name") String name );

    int updatePortraitById(@Param("userId") Long id, @Param("portrait") String portrait );

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}