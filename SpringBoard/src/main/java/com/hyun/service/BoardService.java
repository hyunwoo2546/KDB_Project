package com.hyun.service;

import java.util.List;

import com.hyun.domain.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> list() throws Exception;
	
	public int regi(BoardDTO dto) throws Exception;
	
}
