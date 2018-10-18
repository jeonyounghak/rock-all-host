package com.example.rockalhost.service.recruit;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.recruit.dao.RecruitDAO;
import com.example.rockalhost.model.recruit.dto.ApplDTO;
import com.example.rockalhost.model.recruit.dto.RecruitDTO;
import com.example.rockalhost.model.recruit.dto.ViewMemberDTO;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Inject
	RecruitDAO recruitDao;

	@Override
	public List<RecruitDTO> list(String search_option, String keyword, int start, int end) throws Exception {
		return recruitDao.list(search_option,keyword,start,end);
	}

	@Override
	public RecruitDTO view(int idx) {
		return recruitDao.view(idx);
	}

	@Override
	public void create(RecruitDTO dto) throws Exception {
		recruitDao.create(dto);	
	}

	@Override
	public void appl(ApplDTO dto) {
		recruitDao.appl(dto);
	}

	@Override
	public List<MemberDTO> check_list(int idx) {
		return recruitDao.check_list(idx);
	}

	@Override
	public ViewMemberDTO profile(String writer) {
		return recruitDao.profile(writer);
	}

	@Override
	public void appr(String id, int idx, int band, String nickName) {
		recruitDao.appr(id,idx,band,nickName);
		
	}

	@Override
	public void recommend(RecruitDTO dto) {
		recruitDao.recommend(dto);
		
	}

	@Override
	public AllbandDTO band_profile(String writer) {
		return recruitDao.band_profile(writer);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return recruitDao.countArticle(search_option,keyword);
	}

	@Override
	public String appl_check(String id, int idx) {
		return recruitDao.appl_check(id,idx);
	}

	@Override
	public void readCount(int idx, HttpSession session) {
		long update_time=0;
		if(session.getAttribute("update_time_"+idx)!=null) {
			update_time=(long)session.getAttribute("update_time_"+idx);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 600*1000) {
			recruitDao.readCount(idx);
			session.setAttribute("update_time_"+idx, current_time);
		}
		
	}

	@Override
	public void update(RecruitDTO dto) {
		recruitDao.update(dto);		
	}

	@Override
	public void delete(int idx) {
		recruitDao.delete(idx);		
	}

	@Override
	public int grade_check(String id) {
		return recruitDao.grade_check(id);
	}

	@Override
	public String check_recommend(String id, int idx) {
		return recruitDao.check_recommend(id,idx);
	}

	@Override
	public void delete_recommend(String id, int idx) {
		recruitDao.delete_recommend(id, idx);
	}

	@Override
	public void close(int idx) {
		recruitDao.close(idx);
		
	}



}
