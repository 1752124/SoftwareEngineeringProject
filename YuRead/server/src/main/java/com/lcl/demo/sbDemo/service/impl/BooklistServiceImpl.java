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
    public List<Booklist> getDataByType(Byte type) { return booklistMapper.selectByPrimaryKey(type); }

    @Override
    public int delete(Long id) { return booklistMapper.delete(id); }

    @Override
    public List<Booklist> select(){ return booklistMapper.select(); }

    @Override
    public int insert(Long id, String title, String author, String image, Byte type, String summary, String publisher, String ranking, String category){
        return booklistMapper.insert(id,title,author,image,type,summary,publisher,ranking,category);
    }

    @Override
    public int update(Long id, String title, String author, String image, Byte type, String summary, String publisher, String ranking, String category){
        return booklistMapper.insert(id,title,author,image,type,summary,publisher,ranking,category);
    }


}
