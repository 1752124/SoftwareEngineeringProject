package com.lcl.demo.sbDemo.dao;

import com.lcl.demo.sbDemo.entity.Statistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StatisticMapper {

    Statistic select(@Param("userId") Long userId);

}