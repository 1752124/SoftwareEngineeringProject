package com.lcl.demo.sbDemo.service.impl;

import com.lcl.demo.sbDemo.dao.ReadMapper;
import com.lcl.demo.sbDemo.entity.Read;
import com.lcl.demo.sbDemo.service.ReadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReadServiceImpl implements ReadService {

    @Resource
    private ReadMapper readMapper;


    @Override
    public int insert(Long userId, Long bookId, Integer state, String title, String author, String publisher) {
        return readMapper.insert(userId, bookId, state, title, author, publisher);
    }

    @Override
    public int update(Long userId, Long bookId, Integer state) {
        return readMapper.update(userId, bookId, state);
    }

    @Override
    public List<Read> select(Long userId, Integer state) {
        return readMapper.select(userId, state);
    }

    @Override
    public Read getDataById(Long userId, Long bookId) {
        return readMapper.selectByPrimaryKey(userId, bookId);
    }

    @Override
    public List<Read> selectByLikeTitle(Long userId, String keyword) {
        return readMapper.selectByLikeTitle(userId, keyword);
    }


}
