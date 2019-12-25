package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Booklist;

import java.util.List;

public interface BooklistService {

	List<Booklist> getDataByType(Byte type);

}
