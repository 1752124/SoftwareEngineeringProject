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
@RequestMapping("v2/note-management")
public class NoteController {
    @Autowired
    private NoteServiceImpl noteService;

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

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> showNote(@RequestParam Long userid, @RequestParam Long bookid) {
        //noteService =new NoteServiceImpl();
        List<Note> noteList = noteService.select(userid, bookid);
        return noteList;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteNote(@RequestParam Long noteid) {
        //noteService =new NoteServiceImpl();
        int note = noteService.delete(noteid);
        return note;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    @ResponseBody
    public int updateNote(@RequestParam Long noteid, @RequestParam String content) {
        //noteService =new NoteServiceImpl();
        int note = noteService.update(noteid, content);
        return note;
    }


}