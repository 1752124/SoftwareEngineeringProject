package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Note;

import java.util.List;

public interface NoteService {

	int insert(Long userId, Long bookId, Integer beginPage, Integer endPage, String content);

	List<Note> select (Long userId, Long bookId);

}
