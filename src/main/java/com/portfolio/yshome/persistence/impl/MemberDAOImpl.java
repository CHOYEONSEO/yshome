package com.portfolio.yshome.persistence.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.yshome.domain.MemberDTO;
import com.portfolio.yshome.persistence.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.portfolio.yshome.mappers.memberMapper";
	
	@Override
	public int join(MemberDTO mDto) throws Exception {
		int result = sqlSession.insert(namespace + ".join", mDto);
		return result;
	}

	@Override
	public int idCheck(MemberDTO mDto) throws Exception {
		int result = sqlSession.selectOne(namespace + ".idcheck", mDto);
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO mDto) throws Exception {
		mDto = sqlSession.selectOne(namespace + ".login", mDto);
		return mDto;
	}

	@Override
	public MemberDTO mypage(String id) throws Exception {
		MemberDTO mDto = sqlSession.selectOne(namespace + ".mypage", id);
		return mDto;
	}

	@Override
	public void mypageEdit(MemberDTO mDto) throws Exception {
		sqlSession.update(namespace + ".mypageEdit", mDto);
	}

	@Override
	public void delete(MemberDTO mDto) throws Exception {
		sqlSession.delete(namespace + ".delete", mDto);
		
	}

}
