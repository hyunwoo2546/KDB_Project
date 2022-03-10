package com.hyun.dao;

import java.util.List;

import com.hyun.domain.BoardDTO;

public interface BoardDAO {

	public List<BoardDTO> list() throws Exception;
	
	public Integer getMaxSeq() throws Exception;
	
	public int regi(BoardDTO dto);
	
}
