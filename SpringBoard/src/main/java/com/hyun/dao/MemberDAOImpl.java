package com.hyun.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyun.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mapper.member";
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		return sqlSession.selectOne(namespace+ ".login",dto);
	}
	
}
