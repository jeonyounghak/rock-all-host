package com.example.rockalhost.model.member.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.member.dto.MemberSessionDTO;

public interface MemberDAO {
	
	public void insert(MemberDTO dto);
	/*public boolean loginCheck(MemberDTO dto);*/
	public MemberDTO viewMember(String id);
	public Object edit(HttpSession session);
	public void updateMember(MemberDTO dto);
	public boolean checkPasswd(String id, String passwd);
	public void delete(String id);
	public boolean nickCheck(String nickName);
	public boolean join_nickCheck(String nickName);
	public boolean join_idCheck(String id);
	public String idFind(Map<String, String> map);
	public String passwdFind(Map<String, String> map);
	public void passwdUpdate(MemberDTO dto);
	public List<MemberDTO> list(Map<String, Object> map);
	public String loginCheck(MemberDTO dto);
	public void withdrawal(String id);
	public List<MemberDTO> withdrawalList(Map<String, Object> map);
	public void adminUpdateMember(MemberDTO dto);
	public int memberCount();
	public void onclickRestore(MemberDTO dto);
	public int withdrawalCount();
	public List<MemberDTO> searchList(String search_option, String keyword);
	public List<MemberDTO> withdrawalSearchList(String search_option, String keyword);
	public MemberSessionDTO getMemberSession(String id);
}
