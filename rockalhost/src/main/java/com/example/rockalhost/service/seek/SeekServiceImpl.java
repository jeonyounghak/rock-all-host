package com.example.rockalhost.service.seek;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.seek.dao.SeekDAO;
import com.example.rockalhost.model.seek.dto.ApplDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.model.seek.dto.ViewMemberDTO;


@Service
public class SeekServiceImpl implements SeekService {
	
	@Inject
	SeekDAO seekDao;

	@Override
	public List<SeekDTO> list(String search_option, String keyword, int start, int end) throws Exception {
		return seekDao.list(search_option,keyword,start,end);
	}

	@Override
	public SeekDTO view(int idx) {
		return seekDao.view(idx);
	}

	@Override
	public void create(SeekDTO dto) throws Exception {
		seekDao.create(dto);	
	}

	@Override
	public void appl(ApplDTO dto) {
		seekDao.appl(dto);
	}

	@Override
	public List<MemberDTO> check_list(int idx) {
		return seekDao.check_list(idx);
	}

	@Override
	public ViewMemberDTO profile(String writer) {
		return seekDao.profile(writer);
	}

	@Override
	public void appr(String id, int idx) {
		seekDao.appr(id,idx);
		
	}

	@Override
	public void recommend(SeekDTO dto) {
		seekDao.recommend(dto);
		
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return seekDao.countArticle(search_option,keyword);
	}

	@Override
	public String appl_check(String id, int idx) {
		return seekDao.appl_check(id,idx);
	}

	@Override
	public void readCount(int idx, HttpSession session) {
		long update_time=0;
		if(session.getAttribute("update_time_"+idx)!=null) {
			update_time=(long)session.getAttribute("update_time_"+idx);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 600*1000) {
			seekDao.readCount(idx);
			session.setAttribute("update_time_"+idx, current_time);
		}
		
	}

	@Override
	public void update(SeekDTO dto) {
		seekDao.update(dto);		
	}

	@Override
	public void delete(int idx) {
		seekDao.delete(idx);		
	}

	@Override
	public int grade_check(String id) {
		return seekDao.grade_check(id);
	}

	@Override
	public String check_recommend(String id, int idx) {
		return seekDao.check_recommend(id,idx);
	}

	@Override
	public void delete_recommend(String id, int idx) {
		seekDao.delete_recommend(id, idx);
	}



}
