package com.lcl.demo.sbDemo.service.impl;

import com.lcl.demo.sbDemo.dao.NoteMapper;
import com.lcl.demo.sbDemo.entity.Note;
import com.lcl.demo.sbDemo.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteMapper noteMapper;


    @Override
    public int insert(Note note){
        return noteMapper.insert(note);
    }

    @Override
    public List<Note> select(Long userId, Long bookId){
        return noteMapper.select(userId, bookId);
    }

    @Override
    public int delete(Long noteId){
        return noteMapper.delete(noteId);
    }

    @Override
    public int update(Long noteId, String content){
        return noteMapper.update(noteId, content);
    }

}
