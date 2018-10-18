package com.example.rockalhost.model.seek.dao;

import java.util.List;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.seek.dto.ApplDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.model.seek.dto.ViewMemberDTO;

public interface SeekDAO {
	
	public List<SeekDTO> list(String search_option, String keyword, int start, int end) throws Exception;
	public SeekDTO view(int idx);
	public void create(SeekDTO dto)throws Exception;
	public void addattach(String fullName)throws Exception;
	public void appl(ApplDTO dto);
	public List<MemberDTO> check_list(int idx);
	public ViewMemberDTO profile(String writer);
	public void appr(String id, int idx);
	public void recommend(SeekDTO dto);
	public AllbandDTO band_profile(String writer);
	public int countArticle(String search_option, String keyword) throws Exception;
	public String appl_check(String id, int idx);
	public void readCount(int idx);
	public void update(SeekDTO dto);
	public void delete(int idx);
	public int grade_check(String id);
	public String check_recommend(String id, int idx);
	public void delete_recommend(String id, int idx);


}
