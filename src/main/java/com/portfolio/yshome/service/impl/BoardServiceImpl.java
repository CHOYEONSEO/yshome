package com.portfolio.yshome.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.yshome.domain.BoardDTO;
import com.portfolio.yshome.domain.CriteriaDTO;
import com.portfolio.yshome.domain.FileDTO;
import com.portfolio.yshome.persistence.IBoardDAO;
import com.portfolio.yshome.service.IBoardService;

@Service
public class BoardServiceImpl implements IBoardService{

	@Inject
	private IBoardDAO bDao;
	
	@Override
	public void regist(BoardDTO bDto) throws Exception {
		bDao.create(bDto);
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
		return bDao.read(bno);
	}

	@Override
	public void modify(BoardDTO bDto) throws Exception {
		bDao.update(bDto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		bDao.delete(bno);
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return bDao.listAll();
	}

	@Override
	public BoardDTO detail(Integer bno, Integer viewcnt) throws Exception {
		return bDao.detail(bno, viewcnt);
	}

	@Override
	public BoardDTO modify_form(Integer bno) throws Exception {
		return bDao.modify_form(bno);
	}

	@Override
	public void detailcnt(BoardDTO vDto) throws Exception {
		bDao.detailcnt(vDto);
	}

	@Override
	public List<BoardDTO> listCriteria(CriteriaDTO criDto) throws Exception {
		
		return bDao.listCriteria(criDto);
	}

	@Override
	public int paperNum(CriteriaDTO criDto) throws Exception {
		
		return bDao.paperNum(criDto);
	}

	@Override
	public void comment(BoardDTO bDto) throws Exception {
		bDao.comment(bDto);
	}

	@Override
	public void fileUpload(FileDTO fDto) throws Exception {
		bDao.fileUpload(fDto);
	}
}
