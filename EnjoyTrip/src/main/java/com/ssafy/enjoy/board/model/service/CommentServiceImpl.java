package com.ssafy.enjoy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.enjoy.board.model.Board;
import com.ssafy.enjoy.board.model.Comment;
import com.ssafy.enjoy.board.model.mapper.CommentMapper;

public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public List<Comment> getList(Board board) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
