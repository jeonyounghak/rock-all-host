package com.example.rockalhost.model.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardDTO> list(Map<String, Object> map) {
		return sqlSession.selectList("board.list", map);
	}
	@Override
	public BoardDTO view(int num) {
		return sqlSession.selectOne("board.view", num);
	}
	@Override
	public void insert(BoardDTO dto) {
		sqlSession.insert("board.insert", dto);
	}
	@Override
	public boolean passwdCheck(BoardDTO dto) {
		int result = sqlSession.selectOne("board.passwdCheck", dto);
		return (result == 0) ? false : true;
	}
	@Override
	public void hidden(BoardDTO dto) {
		sqlSession.update("board.hidden", dto);
	}
	@Override
	public void update(BoardDTO dto) {
		sqlSession.update("board.update", dto);
	}
	@Override
	public void reply(BoardDTO dto) {
		sqlSession.insert("board.reply", dto);
	}
	@Override
	public void plusReadcount(int num, HttpSession count_session) {
		long read_time = 0;
		if(count_session.getAttribute("read_time_"+num) != null) {
			read_time = (long)count_session.getAttribute("read_time_"+num);
		}
		
		long current_time = System.currentTimeMillis();
		if(current_time - read_time > 24 * 60 * 60 * 1000) {
			sqlSession.update("board.plusReadcount", num);
			count_session.setAttribute("read_time_"+num, current_time);
		}
	}
	@Override
	public int getCount(Map<String, String> count_map) {
		return sqlSession.selectOne("board.getCount", count_map);
	}
	@Override
	public int searchCount(Map<String, String> count_map) {
		return sqlSession.selectOne("board.searchCount", count_map);
	}
	
	
	@Override
	public int adminCount(Map<String, String> search_map) {
		return sqlSession.selectOne("board.adminCount", search_map);
	}
	@Override
	public List<BoardDTO> adminList(Map<String, Object> map) {
		return sqlSession.selectList("board.adminList", map);
	}
	
	
}
