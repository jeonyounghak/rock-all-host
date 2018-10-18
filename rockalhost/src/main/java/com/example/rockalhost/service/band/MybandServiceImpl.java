package com.example.rockalhost.service.band;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.band.dao.MybandDAO;
import com.example.rockalhost.model.band.dto.MybandDTO;
import com.example.rockalhost.model.member.dao.MemberDAO;
import com.example.rockalhost.model.member.dto.MemberDTO;



@Service
public class MybandServiceImpl implements MybandService {
	
	@Inject
	MybandDAO mybandDao;
	MemberDAO memberDao;
	
	@Override
	public List<MybandDTO> list(int band) {		
		return mybandDao.list(band);
	}	
	@Override
	public List<MybandDTO> leaderlist(int band) {		
		return mybandDao.leaderlist(band);
	}	
	@Override
	public MemberDTO temperProfile(String nickName) {
		return mybandDao.temperProfile(nickName);
	}
	@Override
	public void temperUpdate(MemberDTO dto) {
		mybandDao.temperUpdate(dto);
	}
	@Override
	public void temperDelete(MemberDTO dto) {
		mybandDao.temperDelete(dto);
	}
	@Override
	public void mytemperDelete(MemberDTO dto) {
		mybandDao.mytemperDelete(dto);
	}
	@Override
	public void adminBandDelete(MemberDTO dto) {
		mybandDao.adminBandDelete(dto);
	}	
}

	

