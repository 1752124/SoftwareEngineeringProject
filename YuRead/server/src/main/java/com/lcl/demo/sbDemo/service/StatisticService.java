package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Statistic;

public interface StatisticService {

//	int insertDataById(Long id);
//
//	int updateName(Long id, String name);
//
//	int updatePortrait(Long id, String url);

	Statistic select(Long userId);

}
