package com.portfolio.yshome.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.yshome.domain.MemberDTO;
import com.portfolio.yshome.persistence.MemberDAO;
import com.portfolio.yshome.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO mDao;
	
	@Override
	public int join(MemberDTO mDto) throws Exception {
		int result = mDao.join(mDto);
		return result;
	}

	@Override
	public int idCheck(MemberDTO mDto) throws Exception {
		int result = mDao.idCheck(mDto);
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO mDto) throws Exception {
		mDto = mDao.login(mDto);
		return mDto;
	}

	@Override
	public MemberDTO mypage(String id) throws Exception {
		MemberDTO mDto = mDao.mypage(id);
		return mDto;
	}

	@Override
	public void mypageEdit(MemberDTO mDto) throws Exception {
		mDao.mypageEdit(mDto);
	}

	@Override
	public void delete(MemberDTO mDto) throws Exception {
		mDao.delete(mDto);
	}


}
