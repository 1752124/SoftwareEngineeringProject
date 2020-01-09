package com.lcl.demo.sbDemo.controller;

import java.util.List;

import com.lcl.demo.sbDemo.entity.Note;
import com.lcl.demo.sbDemo.service.impl.NoteServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("v2/note-management")
public class NoteController {
    @Autowired
    private NoteServiceImpl noteService;

    @ApiOperation(value="录入书摘", notes="添加书摘")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "书籍isbn", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "bookid", value = "书名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "beginpage", value = "作者", required = true, paramType = "String"),
            @ApiImplicitParam(name = "endpage", value = "封面", required = true, paramType = "String"),
            @ApiImplicitParam(name = "content", value = "推荐类别", required = true, paramType = "Byte"),
    })
    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    @ResponseBody
    public Long addNote( @RequestParam Long userid, @RequestParam Long bookid, @RequestParam Integer beginpage, @RequestParam Integer endpage, @RequestParam String content) {
        //noteService =new NoteServiceImpl();
        Note note = new Note();
        note.setBeginPage(beginpage);
        note.setEndPage(endpage);
        note.setContent(content);
        note.setUserId(userid);
        note.setBookId(bookid);
        noteService.insert(note);
        return note.getNoteId();
    }

    @ApiOperation(value="进入书籍查看书摘", notes="查看书摘")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户手机号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "bookid", value = "书籍isbn", required = true, paramType = "Long"),
    })
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> showNote(@RequestParam Long userid, @RequestParam Long bookid) {
        //noteService =new NoteServiceImpl();
        List<Note> noteList = noteService.select(userid, bookid);
        return noteList;
    }

    @ApiOperation(value="删减书摘", notes="删减书摘")
    @ApiImplicitParam(name = "noteid", value = "书摘编号", required = true, paramType = "Long")
    @RequestMapping(value = "/notes", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteNote(@RequestParam Long noteid) {
        //noteService =new NoteServiceImpl();
        int note = noteService.delete(noteid);
        return note;
    }

    @ApiOperation(value="修改书摘", notes="修改书摘")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noteid", value = "书摘编号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "content", value = "书摘内容", required = true, paramType = "String"),
    })
    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    @ResponseBody
    public int updateNote(@RequestParam Long noteid, @RequestParam String content) {
        //noteService =new NoteServiceImpl();
        int note = noteService.update(noteid, content);
        return note;
    }


}