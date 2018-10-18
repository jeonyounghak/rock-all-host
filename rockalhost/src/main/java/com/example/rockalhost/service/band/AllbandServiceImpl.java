package com.example.rockalhost.service.band;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.band.dao.AllbandDAO;
import com.example.rockalhost.model.band.dao.MybandDAO;
import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.band.dto.AllbandViewDTO;
import com.example.rockalhost.model.member.dao.MemberDAO;
import com.example.rockalhost.model.member.dto.MemberDTO;


@Service
public class AllbandServiceImpl implements AllbandService {
	
	@Inject
	AllbandDAO allbandDao;
	@Inject
	MybandDAO mybandDao;
	@Inject
	MemberDAO memberDao;
	
	
	@Override
	public List<AllbandViewDTO> list(Map<String, Object> map) {
		return allbandDao.list(map);
	}
	@Override
	public void applyview(String nickName) {
		allbandDao.applyview(nickName);
	}	
	@Override
	public void apply(AllbandDTO dto) throws Exception {
		allbandDao.apply(dto);
	}
	@Override
	public List<MemberDTO> adminlist(int idx) {
		return allbandDao.adminlist(idx);
	}
	@Override
	public List<AllbandViewDTO> applylist() {
		return allbandDao.applylist();
	}
	@Override
	public void adminapply(AllbandDTO dto) throws Exception {
		allbandDao.adminapply(dto);
	}
	@Override
	public AllbandViewDTO applyshow(String nickName) {
		return allbandDao.applyshow(nickName);
	}
	@Override
	public AllbandViewDTO mybandview(int b_idx) {
		return allbandDao.mybandview(b_idx);
	}
	@Override
	public void mybandupdate(AllbandDTO dto) {
		allbandDao.mybandupdate(dto);
	}
	@Override
	public MemberDTO memberview(String nickName) {
		return allbandDao.memberview(nickName);
	}
	@Override
	public boolean join_idCheck(String b_name) {
		return allbandDao.join_idCheck(b_name);
	}
	@Override
	public int bandCount() {
		return allbandDao.bandCount();
	}
	@Override
	public List<AllbandViewDTO> bandlist(String search_option, String keyword) {
		return allbandDao.searchList(search_option,keyword);
	}
	@Override
	public int getCheckNick(String b_leaderNick) {
		return allbandDao.getCheckNick(b_leaderNick);
	}
}
