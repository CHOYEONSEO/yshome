package com.portfolio.yshome.persistence;

import java.util.List;

import com.portfolio.yshome.domain.BoardDTO;
import com.portfolio.yshome.domain.CriteriaDTO;
import com.portfolio.yshome.domain.FileDTO;

public interface IBoardDAO {

	public void create(BoardDTO bDto) throws Exception;
	
	public BoardDTO read(Integer bno) throws Exception;
	
	public BoardDTO modify_form(Integer bno) throws Exception;
	
	public void update(BoardDTO bDto) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardDTO> listAll() throws Exception;
	
	public BoardDTO detail(Integer bno, Integer viewcnt) throws Exception;
	
	public void detailcnt(BoardDTO vDto) throws Exception;
	
	public List<BoardDTO> listCriteria(CriteriaDTO criDto) throws Exception;
	
	public int paperNum(CriteriaDTO criDto) throws Exception;
	
	public void comment(BoardDTO bDto) throws Exception;
	
	public void fileUpload(FileDTO fDto) throws Exception;
	
}
