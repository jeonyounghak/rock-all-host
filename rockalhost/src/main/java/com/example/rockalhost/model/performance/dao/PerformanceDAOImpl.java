package com.example.rockalhost.model.performance.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.performance.dto.PerformanceDTO;
import com.example.rockalhost.model.performance.dto.PerformanceViewDTO;

@Repository
public class PerformanceDAOImpl implements PerformanceDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<PerformanceViewDTO> list(Map<String, Object> map) {
		return sqlSession.selectList("performance.list", map);
	}

	@Override
	public PerformanceViewDTO view(int pf_idx) {
		return sqlSession.selectOne("performance.view", pf_idx);
	}

	@Override
	public void insert(PerformanceDTO dto) {
		sqlSession.insert("performance.insert", dto);
	}

	@Override
	public void plusReadcount(int pf_idx, HttpSession count_session) {
		long read_time = 0;
		if(count_session.getAttribute("read_time_"+pf_idx) != null) {
			read_time = (long)count_session.getAttribute("read_time_"+pf_idx);
		}
		
		long current_time = System.currentTimeMillis();
		if(current_time - read_time > 24 * 60 * 60 * 1000) {
			sqlSession.update("performance.plusReadcount", pf_idx);
			count_session.setAttribute("read_time_"+pf_idx, current_time);
		}
	}

	@Override
	public void update(PerformanceDTO dto) {
		sqlSession.update("performance.update", dto);
	}

	@Override
	public void delete(int pf_idx) {
		sqlSession.delete("performance.delete", pf_idx);
	}

	@Override
	public void hide(int pf_idx) {
		sqlSession.update("performance.hide", pf_idx);
	}

	@Override
	public void upCountRemainder(int pf_idx, int count) {
		Map<String, Integer> map = new HashMap<>();
		map.put("pf_idx", pf_idx);
		map.put("count", count);
		
		sqlSession.update("performance.upCountRemainder", map);
	}

	@Override
	public void downCountRemainder(int pf_idx, int count) {
		Map<String, Integer> map = new HashMap<>();
		map.put("pf_idx", pf_idx);
		map.put("count", count);
		
		sqlSession.update("performance.downCountRemainder", map);
	}

	@Override
	public int getCount() {
		return sqlSession.selectOne("performance.getCount");
	}

	@Override
	public int getBandIdx(int pf_idx) {
		return sqlSession.selectOne("performance.getBandIdx", pf_idx);
	}

	@Override
	public int searchCount(Map<String, String> count_map) {
		return sqlSession.selectOne("performance.searchCount", count_map);
	}


}
