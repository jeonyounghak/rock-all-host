package com.example.rockalhost.service.band;

import java.util.List;

import com.example.rockalhost.model.band.dto.MybandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;

public interface MybandService {
	public List<MybandDTO> list(int band);
	public List<MybandDTO> leaderlist(int band);
	public MemberDTO temperProfile(String nickName);
	public void temperUpdate(MemberDTO dto);
	public void temperDelete(MemberDTO dto);
	public void adminBandDelete(MemberDTO dto);
	public void mytemperDelete(MemberDTO dto);

	
}
