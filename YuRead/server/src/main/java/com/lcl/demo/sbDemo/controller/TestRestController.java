package com.lcl.demo.sbDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@RequestMapping("/test")
	public Object test(){
		return "call success";
	}
}
