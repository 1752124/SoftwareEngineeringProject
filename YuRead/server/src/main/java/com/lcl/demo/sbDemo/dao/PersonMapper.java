package com.lcl.demo.sbDemo.dao;


import com.lcl.demo.sbDemo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {

    List<Person> select(@Param("userId") Long userId);

}