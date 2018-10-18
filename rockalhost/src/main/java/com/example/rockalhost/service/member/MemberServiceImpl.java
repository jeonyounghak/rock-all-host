package com.example.rockalhost.service.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.member.dao.MemberDAO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.member.dto.MemberSessionDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAO memberDao;

	@Override
	public void insert(MemberDTO dto) {
		memberDao.insert(dto);	
	}

/*	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		
		boolean result = memberDao.loginCheck(dto);
		if(result) {
			MemberDTO dto2 = viewMember(dto.getId());
			session.setAttribute("id", dto.getId());
			session.setAttribute("nickName", dto2.getNickName());
			session.setAttribute("name", dto2.getName());
		}
		return result;
	}*/
	
	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		
		String result = memberDao.loginCheck(dto);
		if(result != null) {
			MemberDTO dto2 = viewMember(dto.getId());
			MemberSessionDTO memberSessionDto = getMemberSession(dto.getId());
			session.setAttribute("id", dto.getId());
			session.setAttribute("nickName", dto2.getNickName());
			session.setAttribute("name", dto2.getName());
			session.setAttribute("grade", dto2.getMyGrade());
			session.setAttribute("band", dto2.getMyBand());
			session.setAttribute("email", dto2.getEmail());
			session.setAttribute("dto", dto2);
			
			if(dto2.getMyBand() != 0) {
				session.setAttribute("band_name", memberSessionDto.getMyBand());
			}
		}
		return memberDao.loginCheck(dto);
	}
	
	private MemberSessionDTO getMemberSession(String id) {
		return memberDao.getMemberSession(id);
	}
	
	@Override
	public MemberDTO viewMember(String id) {
		return memberDao.viewMember(id);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);
		
	}

	@Override
	public boolean checkPasswd(String id, String passwd) {
		
		return memberDao.checkPasswd(id,passwd);
	}

	@Override
	public void delete(String id) {
		memberDao.delete(id);
		
	}

	@Override
	public boolean nickCheck(String nickName) {
		return memberDao.nickCheck(nickName);
	}

	@Override
	public boolean join_nickCheck(String nickName) {
		return memberDao.join_nickCheck(nickName);
	}

	@Override
	public boolean join_idCheck(String id) {
		return memberDao.join_idCheck(id);
	}

	@Override
	public String idFind(Map<String, String> map) {
		return memberDao.idFind(map);
	}

	@Override
	public String passwdFind(Map<String, String> map) {
		return memberDao.passwdFind(map);
	}

	@Override
	public void passwdUpdate(MemberDTO dto) {
		memberDao.passwdUpdate(dto);
		
	}

/*	@Override
	public List<MemberDTO> list() {
		return memberDao.list();
	}*/

	@Override
	public void withdrawal(String id) {
		memberDao.withdrawal(id);
		
	}

/*	@Override
	public List<MemberDTO> withdrawalList() {
		return memberDao.withdrawalList();
	}*/

	@Override
	public void adminUpdateMember(MemberDTO dto) {
		memberDao.adminUpdateMember(dto);
		
	}

	@Override
	public int memberCount() {
		return memberDao.memberCount();
	}

	@Override
	public void onclickRestore(MemberDTO dto) {
		memberDao.onclickRestore(dto);
		
	}

	@Override
	public int withdrawalCount() {
		return memberDao.withdrawalCount();
	}

	@Override
	public List<MemberDTO> list(String search_option, String keyword) {
		return memberDao.searchList(search_option,keyword);
	}

	@Override
	public List<MemberDTO> withdrawalList(String search_option, String keyword) {
		return memberDao.withdrawalSearchList(search_option,keyword);
	}

	@Override
	public List<MemberDTO> list(Map<String, Object> map) {
		return memberDao.list(map);
	}

	@Override
	public List<MemberDTO> withdrawalList(Map<String, Object> map) {
		return memberDao.withdrawalList(map);
	}

}
