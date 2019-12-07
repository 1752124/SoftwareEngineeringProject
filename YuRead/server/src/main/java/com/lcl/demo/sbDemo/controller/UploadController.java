package com.lcl.demo.sbDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lcl.demo.sbDemo.other.util.MyFileUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Value("${uploadPath}")
	String uploadPath;
	
	//处理文件上传
    @RequestMapping(value="/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
    	ModelMap resultMap = new ModelMap();
    	if(file!=null && !file.isEmpty()){
    		String msg = "SUCCESS";
            String fileName = file.getOriginalFilename();
//            String filePath = "C:\\Users\\Administrator\\Desktop\\test\\upload\\img\\";
            String filePath = uploadPath+"img\\";
            System.err.println("上传路径:"+filePath);
            try {
                MyFileUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
            	msg = e.getMessage();
            }
            //返回json
            resultMap.put("msg", msg);
    	}
        return resultMap;
    }

}
