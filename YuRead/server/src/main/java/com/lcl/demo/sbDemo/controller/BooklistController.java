package com.lcl.demo.sbDemo.controller;

import java.util.List;

import com.lcl.demo.sbDemo.entity.Booklist;
import com.lcl.demo.sbDemo.service.impl.BooklistServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v2/booklist-management")
public class BooklistController {
    @Autowired
    private BooklistServiceImpl booklistService;

    @RequestMapping(value = "/booklists", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showBook(@RequestParam Byte type) {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklistList  = booklistService.getDataByType(type);
        return booklistList;
    }

    @RequestMapping(value = "/booklistlists", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showAllBook() {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklists  = booklistService.select();
        return booklists;
    }

    @RequestMapping(value = "/booklists", method = RequestMethod.POST)
    @ResponseBody
    public int addBook(@RequestParam Long id, @RequestParam String title, @RequestParam String author, @RequestParam String image, @RequestParam Byte type, @RequestParam String summary, @RequestParam String publisher, @RequestParam String ranking, @RequestParam String category) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.insert(id,title,author,image,type,summary,publisher,ranking,category);
        return book;
    }

    @RequestMapping(value = "/booklists", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteBook(@RequestParam Long id) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.delete(id);
        return book;
    }

    @RequestMapping(value = "/booklists", method = RequestMethod.PUT)
    @ResponseBody
    public int updateBook(@RequestParam Long id, @RequestParam String title, @RequestParam String author, @RequestParam String image, @RequestParam Byte type, @RequestParam String summary, @RequestParam String publisher, @RequestParam String ranking, @RequestParam String category) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.update(id,title,author,image,type,summary,publisher,ranking,category);
        return book;
    }

}


