package com.portfolio.yshome.persistence.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.yshome.domain.BoardDTO;
import com.portfolio.yshome.domain.CriteriaDTO;
import com.portfolio.yshome.domain.FileDTO;
import com.portfolio.yshome.persistence.IBoardDAO;

@Repository
public class BoardDAOImpl implements IBoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.portfolio.yshome.mappers.boardMapper";
	
	@Override
	public void create(BoardDTO bDto) throws Exception {
		sqlSession.insert(namespace + ".create", bDto);
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
		
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardDTO bDto) throws Exception {
		sqlSession.update(namespace + ".update", bDto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(namespace + ".delete", bno);
		
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		List<BoardDTO> list = sqlSession.selectList(namespace + ".listAll");
		return list;
	}
	
	@Override
	public BoardDTO detail(Integer bno, Integer viewcnt) throws Exception {
		sqlSession.update(namespace + ".detail", viewcnt);
		BoardDTO bDto = sqlSession.selectOne(namespace + ".detail", bno);
		return bDto;
	}

	@Override
	public BoardDTO modify_form(Integer bno) throws Exception {
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void detailcnt(BoardDTO vDto) throws Exception {
		sqlSession.update(namespace + ".detailcnt", vDto);
		
	}

	@Override
	public List<BoardDTO> listCriteria(CriteriaDTO criDto) throws Exception {
		
		return sqlSession.selectList(namespace + ".listCriteria", criDto);
	}

	@Override
	public int paperNum(CriteriaDTO criDto) throws Exception {
		
		return sqlSession.selectOne(namespace + ".paperNum", criDto);
	}

	@Override
	public void comment(BoardDTO bDto) throws Exception {
		sqlSession.insert(namespace + ".comment", bDto);
	}

	@Override
	public void fileUpload(FileDTO fDto) throws Exception {
		sqlSession.insert(namespace + ".fileUpload", fDto);
		
	}

}
