package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Read;

import java.util.List;

public interface ReadService {

	int insert(Long userId, Long bookId, Integer state);

	int update(Long userId, Long bookId, Integer state);

	List<Read> select(Long userId, Integer state);

	Read getDataById(Long id);

	List<Read> selectByLikeTitle(String  keyword);

}
