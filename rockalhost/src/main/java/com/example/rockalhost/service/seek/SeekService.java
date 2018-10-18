package com.example.rockalhost.service.seek;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.seek.dto.ApplDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.model.seek.dto.ViewMemberDTO;


public interface SeekService {
	
	public List<SeekDTO> list(String search_option, String keyword, int start, int end) throws Exception;
	public SeekDTO view(int idx);
	public void create(SeekDTO dto) throws Exception;
	public void appl(ApplDTO dto);
	public List<MemberDTO> check_list(int idx);
	public ViewMemberDTO profile(String writer);
	public void appr(String id, int idx);
	public void recommend(SeekDTO dto);
	public int countArticle(String search_option, String keyword) throws Exception;
	public String appl_check(String id, int idx);
	public void readCount(int idx, HttpSession session);
	public void update(SeekDTO dto);
	public void delete(int idx);
	public int grade_check(String id);
	public String check_recommend(String id, int idx);
	public void delete_recommend(String id, int idx);

}
