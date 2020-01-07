package com.lcl.demo.sbDemo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lcl.demo.sbDemo.entity.User;
import org.springframework.stereotype.Service;

import com.lcl.demo.sbDemo.dao.UserMapper;
import com.lcl.demo.sbDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public int insertDataById(Long id) {
        return userMapper.insert(id);
    }

    @Override
    public int updateName(Long id, String name) {
        return userMapper.updateNameById(id, name);
    }

    @Override
    public int updatePortrait(Long id, String url) {
        return userMapper.updatePortraitById(id, url);
    }

    @Override
    public User selectByPrimaryKey(Long id)  {
        return userMapper.selectByPrimaryKey(id);
    }

}
