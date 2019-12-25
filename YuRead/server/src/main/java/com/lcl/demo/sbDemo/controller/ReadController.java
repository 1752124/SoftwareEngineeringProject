package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Read;
import com.lcl.demo.sbDemo.service.impl.ReadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("v1/read-management")
public class ReadController {
    @Autowired
    private ReadServiceImpl readService;

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public int addBook(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam Integer state, @RequestParam String title, @RequestParam String author, @RequestParam String publisher) {
        //readingService =new readingServiceImpl();
        int book = readService.insert(userId, bookId, state, title, author, publisher);
        return book;
    }

    @RequestMapping(value = "/lists", method = RequestMethod.POST)
    @ResponseBody
    public int changeBook(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam Integer state) {
        //readingService =new readingServiceImpl();
        int book = readService.update(userId, bookId, state);
        return book;
    }

    @RequestMapping(value = "/shelves", method = RequestMethod.GET)
    @ResponseBody
    public List<Read> showBooks(@RequestParam Long userId, @RequestParam Integer state) {
        //readingService =new readingServiceImpl();
        List<Read> bookList = readService.select(userId, state);
        return bookList;
    }

    @RequestMapping(value = "/isbns", method = RequestMethod.GET)
    @ResponseBody
    public Read isbns(@RequestParam Long userId, @RequestParam Long bookId) {
        //readService =new readServiceImpl();
        Read book = readService.getDataById(userId, bookId);
        return book;
    }

    @RequestMapping(value = "/titles", method = RequestMethod.GET)
    @ResponseBody
    public List<Read> titles(@RequestParam Long userId, @RequestParam String keyword) {
        List<Read> bookList = readService.selectByLikeTitle(userId, keyword);
        return bookList;
    }


}
