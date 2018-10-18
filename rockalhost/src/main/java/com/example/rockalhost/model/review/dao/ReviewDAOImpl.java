package com.example.rockalhost.model.review.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;
import com.example.rockalhost.model.subBoardComment.dto.SubBoardCommentDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<SubBoardDTO> list(Map<String, Integer> map) {
		return sqlSession.selectList("reviewBoard.list", map);
	}

	@Override
	public void plusReadcount(int num, HttpSession count_session) {
		long read_time = 0;
		if(count_session.getAttribute("read_time_"+num) != null) {
			read_time = (long)count_session.getAttribute("read_time_"+num);
		}
		
		long current_time = System.currentTimeMillis();
		if(current_time - read_time > 24 * 60 * 60 * 1000) {
			sqlSession.update("reviewBoard.plusReadcount", num);
			count_session.setAttribute("read_time_"+num, current_time);
		}
	}

	@Override
	public SubBoardDTO view(int num) {
		return sqlSession.selectOne("reviewBoard.view", num);
	}

	@Override
	public void insert(SubBoardDTO dto) {
		sqlSession.insert("reviewBoard.insert", dto);
	}

	@Override
	public boolean passwdCheck(SubBoardDTO dto) {
		int result = sqlSession.selectOne("reviewBoard.passwdCheck", dto);
		return (result == 0) ? false : true;
	}

	@Override
	public void update(SubBoardDTO dto) {
		sqlSession.update("reviewBoard.update", dto);
	}

	@Override
	public void hidden(SubBoardDTO dto) {
		sqlSession.update("reviewBoard.hidden", dto);
	}
	@Override
	public int getCount(int pf_idx) {
		return sqlSession.selectOne("reviewBoard.getCount", pf_idx);
	}
	
	
	
	@Override
	public List<SubBoardCommentDTO> commentList(int num) {
		return sqlSession.selectList("reviewBoard.commentList", num);
	}

	@Override
	public void commentInsert(SubBoardCommentDTO dto) {
		sqlSession.selectList("reviewBoard.commentInsert", dto);
	}

	@Override
	public SubBoardCommentDTO commentView(int comment_num) {
		return sqlSession.selectOne("reviewBoard.commentView", comment_num);
	}

	@Override
	public boolean commentPasswdCheck(SubBoardCommentDTO dto) {
		boolean result = false;
		int count = sqlSession.selectOne("reviewBoard.commentPasswdCheck", dto);
			
		if(count == 1) {
			result = true;
		}
		return result;
	}

	@Override
	public void commentDelete(int comment_num) {
		sqlSession.selectList("reviewBoard.commentDelete", comment_num);
	}

	
	@Override
	public int getBandRBCount(Map<String, Object> search_map) {
		return sqlSession.selectOne("reviewBoard.getBandRBCount", search_map);
	}
	@Override
	public List<SubBoardDTO> rbList(Map<String, Object> map) {
		return sqlSession.selectList("reviewBoard.rbList", map);
	}

	
	@Override
	public int getAdminCount(Map<String, String> search_map) {
		return sqlSession.selectOne("reviewBoard.getAdminCount", search_map);
	}
	@Override
	public List<SubBoardDTO> adminList(Map<String, Object> map) {
		return sqlSession.selectList("reviewBoard.adminList", map);
	}


}
