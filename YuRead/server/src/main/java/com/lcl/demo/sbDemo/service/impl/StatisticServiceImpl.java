package com.lcl.demo.sbDemo.service.impl;

import com.lcl.demo.sbDemo.dao.StatisticMapper;
import com.lcl.demo.sbDemo.entity.Statistic;
import com.lcl.demo.sbDemo.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;


//    @Override
//    public int insertDataById(Long id) {
//        return userMapper.insert(id);
//    }
//
//    @Override
//    public int updateName(Long id, String name) {
//        return userMapper.updateNameById(id, name);
//    }
//
//    @Override
//    public int updatePortrait(Long id, String url) {
//        return userMapper.updatePortraitById(id, url);
//    }

    @Override
    public Statistic select(Long userId)  {
        return statisticMapper.select(userId);
    }

}
