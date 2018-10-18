package com.example.rockalhost.model.qna.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;

@Repository
public class QnaDAOImpl implements QnaDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<SubBoardDTO> list(Map<String, Integer> map) {
		return sqlSession.selectList("qnaBoard.list", map);
	}

	@Override
	public void plusReadcount(int num, HttpSession count_session) {
		long read_time = 0;
		if(count_session.getAttribute("read_time_"+num) != null) {
			read_time = (long)count_session.getAttribute("read_time_"+num);
		}
		
		long current_time = System.currentTimeMillis();
		if(current_time - read_time > 24 * 60 * 60 * 1000) {
			sqlSession.update("qnaBoard.plusReadcount", num);
			count_session.setAttribute("read_time_"+num, current_time);
		}
	}

	@Override
	public SubBoardDTO view(int num) {
		return sqlSession.selectOne("qnaBoard.view", num);
	}

	@Override
	public void insert(SubBoardDTO dto) {
		sqlSession.insert("qnaBoard.insert", dto);
	}

	@Override
	public boolean passwdCheck(SubBoardDTO dto) {
		int result = sqlSession.selectOne("qnaBoard.passwdCheck", dto);
		return (result == 0) ? false : true;
	}

	@Override
	public void update(SubBoardDTO dto) {
		sqlSession.update("qnaBoard.update", dto);
	}

	@Override
	public void hidden(SubBoardDTO dto) {
		sqlSession.update("qnaBoard.hidden", dto);
	}

	@Override
	public void reply(SubBoardDTO dto) {
		sqlSession.insert("qnaBoard.reply", dto);
	}

	@Override
	public int getCount(int pf_idx) {
		return sqlSession.selectOne("qnaBoard.getCount", pf_idx);
	}

	
	@Override
	public int getBandQBCount(Map<String, Object> search_map) {
		return sqlSession.selectOne("qnaBoard.getBandQBCount", search_map);
	}
	@Override
	public List<SubBoardDTO> qbList(Map<String, Object> map) {
		return sqlSession.selectList("qnaBoard.qbList", map);
	}

	@Override
	public int getAdminQBCount(Map<String, Object> search_map) {
		return sqlSession.selectOne("qnaBoard.getAdminQBCount", search_map);
	}
	@Override
	public List<SubBoardDTO> adminQBList(Map<String, Object> map) {
		return sqlSession.selectList("qnaBoard.adminQBList", map);
	}

}
