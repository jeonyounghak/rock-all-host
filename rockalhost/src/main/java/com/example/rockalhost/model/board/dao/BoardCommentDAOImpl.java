package com.example.rockalhost.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.board.dto.BoardCommentDTO;

@Repository
public class BoardCommentDAOImpl implements BoardCommentDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardCommentDTO> list(int num) {
		return sqlSession.selectList("boardComment.list", num);
	}
	@Override
	public void insert(BoardCommentDTO dto) {
		sqlSession.selectList("boardComment.insert", dto);
	}
	@Override
	public void delete(int comment_num) {
		sqlSession.selectList("boardComment.delete", comment_num);
	}
	@Override
	public BoardCommentDTO view(int comment_num) {
		return sqlSession.selectOne("boardComment.view", comment_num);
	}
	@Override
	public boolean passwdCheck(BoardCommentDTO dto) {
		boolean result = false;
		int count = sqlSession.selectOne("boardComment.passwdCheck", dto);
			
		if(count == 1) {
			result = true;
		}
		
		return result;
	}

}
