package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Booklist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooklistService {

	List<Booklist> getDataByType(Byte type);

    int delete(Long id);

	List<Booklist> select();

	int insert(Long id, String title, String author, String image, Byte type, String summary, String publisher, String ranking, String category);

	int update(Long id, String title, String author, String image, Byte type, String summary, String publisher, String ranking, String category);

}
