package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.User;

import java.util.List;

public interface UserService {

	int insertDataById(Long id);

	int updateName(Long id, String name);

	int updatePortrait(Long id, String url);

	User selectByPrimaryKey(Long id);

}
