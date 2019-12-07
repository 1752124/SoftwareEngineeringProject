package com.lcl.demo.sbDemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	/**
	 * @Description : 处理错误请求，返回错误页面error.html
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/error", produces= "text/html")
	public Object handleErrorHtml(ModelMap map, HttpServletRequest request){
		map.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
		map.put("url", request.getAttribute("javax.servlet.error.request_uri"));
		map.put("ex", request.getAttribute("javax.servlet.error.exception"));
		return getErrorPath();
	}
	
	/**
	 * @Description : 处理错误请求，返回Json数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/error")
	@ResponseBody
	public Object handleError(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
		resultMap.put("url", request.getAttribute("javax.servlet.error.request_uri"));
		resultMap.put("ex", request.getAttribute("javax.servlet.error.exception"));
		return resultMap;
	}
}
