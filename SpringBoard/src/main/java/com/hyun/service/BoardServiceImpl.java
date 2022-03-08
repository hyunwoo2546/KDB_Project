package com.hyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyun.dao.BoardDAO;
import com.hyun.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardDTO> list() throws Exception {
		return dao.list();
	}
	
}
