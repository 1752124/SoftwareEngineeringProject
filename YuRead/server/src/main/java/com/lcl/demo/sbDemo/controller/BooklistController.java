package com.lcl.demo.sbDemo.controller;

import java.util.List;

import com.lcl.demo.sbDemo.entity.Booklist;
import com.lcl.demo.sbDemo.service.impl.BooklistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v1/booklist-management")
public class BooklistController {
    @Autowired
    private BooklistServiceImpl booklistService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showBook(@RequestParam Byte type) {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklistList  = booklistService.getDataByType(type);
        return booklistList;
    }

}
