package com.hyun.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.hyun.mapper.board";
	
	@Override
	public List<BoardDTO> list() throws Exception {
		return sqlSession.selectList(namespace + ".list");
	}
	
	@Override
	public Integer getMaxSeq(){
		return sqlSession.selectOne(namespace+ ".maxSeq");
	}
	
	@Override
	public int regi(BoardDTO dto) {
		return sqlSession.insert(namespace+".regi",dto);
	}
	
	@Override
	public BoardDTO view(int seq) throws Exception {
		return sqlSession.selectOne(namespace + ".view", seq);
	}
	
	@Override
	public void updateReadCount(int seq) throws Exception {
		sqlSession.update(namespace + "updateReadCount",seq);
	}
	
}
