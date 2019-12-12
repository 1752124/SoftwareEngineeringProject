package com.lcl.demo.sbDemo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcl.demo.sbDemo.dao.UserMapper;
import com.lcl.demo.sbDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserMapper userMapper;
	
	public List<Map<String, Object>> getDatas(String name){
		return userMapper.getDatas(name);
	}

	@Override
	public Map<String, Object> getDataById(Integer id) {
		return userMapper.getDataById(id);
	}

}
