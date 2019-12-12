package com.lcl.demo.sbDemo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcl.demo.sbDemo.other.annotation.MyAnnotation;
import com.lcl.demo.sbDemo.service.UserService;


@Controller
public class TestController {
	
	@Resource
	UserService userService;

	@RequestMapping("/hello")
	public Object hello(ModelMap map){
		map.put("msg", "hello world!");
		map.put("userList", null);
		return "hello";
	}
	
	@RequestMapping("/testErr")
	@ResponseBody
	public Object testErr(){
		int result;
		result = 100/0;
		return result;
	}
	
	@RequestMapping("/testAsp")
	@ResponseBody
	@MyAnnotation(operate="执行测试操作",isSave=false)
	public Object testAspect(@RequestParam(name="name",required=false,defaultValue="佚名") String name){
		System.out.println("我是用户:"+name);
		return name;
	}
	
}
