package com.portfolio.yshome.persistence;

import com.portfolio.yshome.domain.MemberDTO;

public interface MemberDAO {

	public int join(MemberDTO mDto) throws Exception;
	
	public int idCheck(MemberDTO mDto) throws Exception;
	
	public MemberDTO login(MemberDTO mDto) throws Exception;
	
	public MemberDTO mypage(String id) throws Exception;
	
	public void mypageEdit(MemberDTO mDto) throws Exception;
	
	public void delete(MemberDTO mDto) throws Exception;
}
