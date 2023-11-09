package com.ssafy.enjoy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoy.board.model.Board;
import com.ssafy.enjoy.board.model.Page;
import com.ssafy.enjoy.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList(Page page) throws Exception {
		
		return null;
	}

	@Override
	public void writeBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board getDetail(Board board) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPageNum() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
