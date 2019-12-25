package com.lcl.demo.sbDemo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.lcl.demo.sbDemo.entity.Booklist;
import com.lcl.demo.sbDemo.service.BooklistService;
import org.springframework.stereotype.Service;

import com.lcl.demo.sbDemo.dao.BooklistMapper;

@Service
public class BooklistServiceImpl implements BooklistService {

    @Resource
    private BooklistMapper booklistMapper;


    @Override
    public List<Booklist> getDataByType(Byte type) {
        return booklistMapper.selectByPrimaryKey(type);
    }

}
