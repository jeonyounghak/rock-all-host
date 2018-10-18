package com.example.rockalhost.model.performance.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.performance.dto.PerformanceDTO;
import com.example.rockalhost.model.performance.dto.PerformanceViewDTO;

public interface PerformanceDAO {

	public List<PerformanceViewDTO> list(Map<String, Object> map);
	public PerformanceViewDTO view(int pf_idx);
	public void insert(PerformanceDTO dto);
	public void plusReadcount(int pf_idx, HttpSession session);
	public void update(PerformanceDTO dto);
	public void delete(int pf_idx);
	public void hide(int pf_idx);
	public void downCountRemainder(int pf_idx, int count);
	public void upCountRemainder(int pf_idx, int count);
	public int getCount();
	public int getBandIdx(int pf_idx);
	public int searchCount(Map<String, String> count_map);
	
}
