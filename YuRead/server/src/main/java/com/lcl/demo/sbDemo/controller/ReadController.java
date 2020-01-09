package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Read;
import com.lcl.demo.sbDemo.service.impl.ReadServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v2/read-management")
public class ReadController {
    @Autowired
    private ReadServiceImpl readService;

    @ApiOperation(value="用户在书单添加书籍", notes="添加书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户电话号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "bookid", value = "书籍isbn", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "state", value = "书籍阅读状态", required = true, paramType = "Integer"),
            @ApiImplicitParam(name = "title", value = "书名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "author", value = "作者", required = true, paramType = "String"),
            @ApiImplicitParam(name = "publisher", value = "出版商", required = true, paramType = "String")
    })
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public int addBook(@RequestParam Long userid, @RequestParam Long bookid, @RequestParam Integer state, @RequestParam String title, @RequestParam String author, @RequestParam String publisher) {
        //readingService =new readingServiceImpl();
        int book = readService.insert(userid, bookid, state, title, author, publisher);
        return book;
    }

    @ApiOperation(value="用户更新书籍状态", notes="更新书籍状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户电话号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "bookid", value = "书籍isbn", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "state", value = "书籍阅读状态", required = true, paramType = "Integer")
    })
    @RequestMapping(value = "/states", method = RequestMethod.POST)
    @ResponseBody
    public int changeBook(@RequestParam Long userid, @RequestParam Long bookid, @RequestParam Integer state) {
        //readingService =new readingServiceImpl();
        int book = readService.update(userid, bookid, state);
        return book;
    }

    @ApiOperation(value="查看用户书单", notes="查看书单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户电话号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "state", value = "书籍阅读状态", required = true, paramType = "Integer")
    })
    @RequestMapping(value = "/states", method = RequestMethod.GET)
    @ResponseBody
    public List<Read> showBooks(@RequestParam Long userid, @RequestParam Integer state) {
        //readingService =new readingServiceImpl();
        List<Read> bookList = readService.select(userid, state);
        return bookList;
    }

    @ApiOperation(value="按照isbn查找书籍", notes="按照isbn查找书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户电话号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "bookid", value = "书籍isbn", required = true, paramType = "Long")
    })
    @RequestMapping(value = "/isbns", method = RequestMethod.GET)
    @ResponseBody
    public Read isbns(@RequestParam Long userid, @RequestParam Long bookid) {
        //readService =new readServiceImpl();
        Read book = readService.getDataById(userid, bookid);
        return book;
    }

    @ApiOperation(value="按照关键词模糊查找书籍", notes="按照关键词模糊查找书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户电话号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "keyword", value = "关键词", required = true, paramType = "String")
    })
    @RequestMapping(value = "/titles", method = RequestMethod.GET)
    @ResponseBody
    public List<Read> titles(@RequestParam Long userid, @RequestParam String keyword) {
        List<Read> bookList = readService.selectByLikeTitle(userid, keyword);
        return bookList;
    }


}


