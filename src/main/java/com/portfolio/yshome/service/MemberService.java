package com.portfolio.yshome.service;

import com.portfolio.yshome.domain.MemberDTO;

public interface MemberService {

	public int join(MemberDTO mDto) throws Exception;
	
	public int idCheck(MemberDTO mDto) throws Exception;
	
	public MemberDTO login(MemberDTO mDto) throws Exception;
	
	public MemberDTO mypage(String id) throws Exception;
	
	public void mypageEdit(MemberDTO mDto) throws Exception;
	
	public void delete(MemberDTO mDto) throws Exception;
}
