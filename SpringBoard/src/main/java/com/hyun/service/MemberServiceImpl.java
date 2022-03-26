package com.hyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyun.dao.MemberDAO;
import com.hyun.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}
	
}
