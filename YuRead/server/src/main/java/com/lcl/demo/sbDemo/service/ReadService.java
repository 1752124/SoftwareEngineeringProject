package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Read;

import java.util.List;

public interface ReadService {

	int insert(Long userId, Long bookId, Integer state, String title, String author, String publisher);

	int update(Long userId, Long bookId, Integer state);

	List<Read> select(Long userId, Integer state);

	Read getDataById(Long userId, Long bookId);

	List<Read> selectByLikeTitle(Long userId, String  keyword);

}
