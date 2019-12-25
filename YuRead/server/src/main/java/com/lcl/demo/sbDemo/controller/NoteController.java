package com.lcl.demo.sbDemo.controller;

import java.util.List;

import com.lcl.demo.sbDemo.entity.Note;
import com.lcl.demo.sbDemo.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v1/note-management")
public class NoteController {
    @Autowired
    private NoteServiceImpl noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    @ResponseBody
    public int addNote(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam Integer beginPage, @RequestParam Integer endPage, @RequestParam String content) {
        //noteService =new NoteServiceImpl();
        int note = noteService.insert(userId, bookId, beginPage, endPage, content);
        return note;
    }

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> showNote(@RequestParam Long userId, @RequestParam Long bookId) {
        //noteService =new NoteServiceImpl();
        List<Note> noteList = noteService.select(userId, bookId);
        return noteList;
    }


}