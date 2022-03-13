package com.hyun.dao;

import java.util.List;

import com.hyun.domain.BoardDTO;

public interface BoardDAO {

	public List<BoardDTO> list() throws Exception;
	
	public Integer getMaxSeq() throws Exception;
	
	public int regi(BoardDTO dto);
	
	public BoardDTO view(int seq) throws Exception;
	
	public void updateReadCount(int seq) throws Exception;
	
	public int update(BoardDTO dto) throws Exception;
	
	public int delete(int seq) throws Exception;
	
}
