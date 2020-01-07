package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Note;

import java.util.List;

public interface NoteService {

	int insert(Note note);

	List<Note> select (Long userId, Long bookId);

	int delete(Long noteId);

	int update(Long noteId, String content);

}
