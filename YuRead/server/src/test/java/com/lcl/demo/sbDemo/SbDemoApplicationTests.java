package com.lcl.demo.sbDemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lcl.demo.sbDemo.dao.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbDemoApplicationTests {

	@Value("${uploadPath}")
	String uploadPath;
	@Autowired
	UserMapper userMapper; 
	@Test
	public void contextLoads() {
		System.err.println("---------------TEST BEGIN---------------");
		String path = uploadPath;

		System.err.println(path);
		System.err.println("---------------TEST END---------------");
	}
}
