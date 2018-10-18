package com.example.rockalhost.service.band;

import java.util.List;
import java.util.Map;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.band.dto.AllbandViewDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;

public interface AllbandService {

	public List<AllbandViewDTO> list(Map<String, Object> map);
	public void apply(AllbandDTO dto) throws Exception;
	public void applyview(String nickName);
	public List<MemberDTO> adminlist(int idx);
	public List<AllbandViewDTO> applylist();
	public AllbandViewDTO applyshow(String nickName);
	public void adminapply(AllbandDTO dto) throws Exception;
	public AllbandViewDTO mybandview(int b_idx);
	public void mybandupdate(AllbandDTO dto);
	public MemberDTO memberview(String nickName);
	public boolean join_idCheck(String b_name);
	public int bandCount();
	public List<AllbandViewDTO> bandlist(String search_option, String keyword);
	public int getCheckNick(String b_leaderNick);
	

}
