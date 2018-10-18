package com.example.rockalhost.service.performance;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.invitation.dao.InvitationDAO;
import com.example.rockalhost.model.invitation.dto.InvitationDTO;
import com.example.rockalhost.model.performance.dao.PerformanceDAO;
import com.example.rockalhost.model.performance.dto.PerformanceDTO;
import com.example.rockalhost.model.performance.dto.PerformanceViewDTO;

@Service
public class PerformanceServiceImpl implements PerformanceService {
	@Inject
	PerformanceDAO performanceDao;
	
	@Inject
	InvitationDAO invitationDao;
	
	@Override
	public List<PerformanceViewDTO> list(Map<String, Object> map) {
		return performanceDao.list(map);
	}

	@Override
	public PerformanceViewDTO view(int pf_idx) {
		return performanceDao.view(pf_idx);
	}

	@Override
	public void insert(PerformanceDTO dto) {
		performanceDao.insert(dto);
	}

	@Override
	public void plusReadcount(int pf_idx, HttpSession session) {
		performanceDao.plusReadcount(pf_idx, session);
	}

	@Override
	public void update(PerformanceDTO dto) {
		performanceDao.update(dto);
	}

	@Override
	public void delete(int pf_idx) {
		List<InvitationDTO> iv_idxList = invitationDao.getIv_idxList(pf_idx);
		
		for(int i=0;i<iv_idxList.size();i++) {
			invitationDao.deleteAll(iv_idxList.get(i));
		}
		performanceDao.delete(pf_idx);
	}

	@Override
	public void hide(int pf_idx) {
		performanceDao.hide(pf_idx);
	}

	@Override
	public int getCount() {
		return performanceDao.getCount();
	}

	@Override
	public int getBandIdx(int pf_idx) {
		return performanceDao.getBandIdx(pf_idx);
	}

	@Override
	public int searchCount(Map<String, String> count_map) {
		return performanceDao.searchCount(count_map);
	}



}
