package com.lcl.demo.sbDemo.controller;

import java.util.List;

import com.lcl.demo.sbDemo.entity.Booklist;
import com.lcl.demo.sbDemo.service.impl.BooklistServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("v2/booklist-management")
public class BooklistController {
    @Autowired
    private BooklistServiceImpl booklistService;

    @ApiOperation(value="按类别查看推荐书籍", notes="查看推荐书籍")
    @ApiImplicitParam(name = "type", value = "书籍类型", required = true, paramType = "Byte")
    @RequestMapping(value = "/booklists", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showBook(@RequestParam Byte type) {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklistList  = booklistService.getDataByType(type);
        return booklistList;
    }

    @ApiOperation(value="管理员查看推荐书单", notes="查看推荐书单")
    @RequestMapping(value = "/booklistlists", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showAllBook() {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklists  = booklistService.select();
        return booklists;
    }

    @ApiOperation(value="管理员加入书籍", notes="添加书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "书籍isbn", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "title", value = "书名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "author", value = "作者", required = true, paramType = "String"),
            @ApiImplicitParam(name = "image", value = "封面", required = true, paramType = "String"),
            @ApiImplicitParam(name = "type", value = "推荐类别", required = true, paramType = "Byte"),
            @ApiImplicitParam(name = "summary", value = "简介", required = true, paramType = "String"),
            @ApiImplicitParam(name = "publisher", value = "出版商", required = true, paramType = "String"),
            @ApiImplicitParam(name = "ranking", value = "评分", required = true, paramType = "String"),
            @ApiImplicitParam(name = "cateory", value = "标签", required = true, paramType = "String")
    })
    @RequestMapping(value = "/booklists", method = RequestMethod.POST)
    @ResponseBody
    public int addBook(@RequestParam Long id, @RequestParam String title, @RequestParam String author, @RequestParam String image, @RequestParam Byte type, @RequestParam String summary, @RequestParam String publisher, @RequestParam String ranking, @RequestParam String category) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.insert(id,title,author,image,type,summary,publisher,ranking,category);
        return book;
    }

    @ApiOperation(value="管理员删减书籍", notes="删减书籍")
    @ApiImplicitParam(name = "id", value = "书籍isbn", required = true, paramType = "Long")
    @RequestMapping(value = "/booklists", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteBook(@RequestParam Long id) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.delete(id);
        return book;
    }

    @ApiOperation(value="管理员修改书籍信息", notes="修改书籍信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "书籍isbn", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "title", value = "书名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "author", value = "作者", required = true, paramType = "String"),
            @ApiImplicitParam(name = "image", value = "封面", required = true, paramType = "String"),
            @ApiImplicitParam(name = "type", value = "推荐类别", required = true, paramType = "Byte"),
            @ApiImplicitParam(name = "summary", value = "简介", required = true, paramType = "String"),
            @ApiImplicitParam(name = "publisher", value = "出版商", required = true, paramType = "String"),
            @ApiImplicitParam(name = "ranking", value = "评分", required = true, paramType = "String"),
            @ApiImplicitParam(name = "cateory", value = "标签", required = true, paramType = "String")
    })
    @RequestMapping(value = "/booklists", method = RequestMethod.PUT)
    @ResponseBody
    public int updateBook(@RequestParam Long id, @RequestParam String title, @RequestParam String author, @RequestParam String image, @RequestParam Byte type, @RequestParam String summary, @RequestParam String publisher, @RequestParam String ranking, @RequestParam String category) {
        //booklistService =new BooklistServiceImpl();
        int book  = booklistService.update(id,title,author,image,type,summary,publisher,ranking,category);
        return book;
    }

    @ApiOperation(value="分类别查看推荐书籍", notes="查看书籍")
    @ApiImplicitParam(name = "type", value = "推荐类别", required = true, paramType = "Byte")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Booklist> showBooks(@RequestParam Byte type) {
        //booklistService =new BooklistServiceImpl();
        List<Booklist> booklistList  = booklistService.getDataByType(type);
        return booklistList;
    }


}


