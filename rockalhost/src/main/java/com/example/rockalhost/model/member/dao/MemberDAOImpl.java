package com.example.rockalhost.model.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.member.dto.MemberSessionDTO;
import com.example.rockalhost.util.BCrypt;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
	}

	@Override
	public String loginCheck(MemberDTO dto) {
		String name = null;
		
		MemberDTO dtoResult = sqlSession.selectOne("member.loginTest", dto);
		
		if(dtoResult != null) {
			String passwd = dtoResult.getPasswd();
			if(passwd != null) {
				if(BCrypt.checkpw(dto.getPasswd(), passwd)){
					name = dtoResult.getName();
				}else {
					name =null;
				}
			}else {
				name = null;
			}
		}
		return name;
	}
	@Override
	public boolean checkPasswd(String id, String passwd) {
		
		boolean result = false;
		
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("passwd", passwd);
		int count=sqlSession.selectOne("member.checkPasswd", map);
		if(count==1) result = true;
		return result; 
	}
	@Override
	public MemberDTO viewMember(String id) {
		return sqlSession.selectOne("member.viewMember", id);
	}

	@Override
	public Object edit(HttpSession session) {
		return sqlSession.selectOne("member.edit", session);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}


	@Override
	public void delete(String id) {
		sqlSession.delete("member.delete", id);
		
	}

	@Override
	public boolean nickCheck(String nickName) {
		boolean result = false;
		
		int count = sqlSession.selectOne("member.nickCheck", nickName);
		if(count == 0) result = true;
		return result;
	}

	@Override
	public boolean join_nickCheck(String nickName) {
		boolean result = false;
		
		int count = sqlSession.selectOne("member.joinNickCheck", nickName);
		if(count == 0) result = true;
		return result;
	}

	@Override
	public boolean join_idCheck(String id) {
		boolean result = false;
		int count = sqlSession.selectOne("member.joinIdCheck", id);
		if(count == 0) result = true;
		return result;
	}

	@Override
	public String idFind(Map<String, String> map) {
		String userid = sqlSession.selectOne("member.idFind", map);
		return userid;
	}

	@Override
	public String passwdFind(Map<String, String> map) {
		String passwd = sqlSession.selectOne("member.passwdFind", map);
		return passwd;
	}

	@Override
	public void passwdUpdate(MemberDTO dto) {
		sqlSession.update("member.passwdUpdate", dto);
	}

/*	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.list");
	}*/

	@Override
	public void withdrawal(String id) {
		sqlSession.update("member.withdrawal", id);
		
	}

/*	@Override
	public List<MemberDTO> withdrawalList() {
		return sqlSession.selectList("admin.withdrawalList");
	}*/

	@Override
	public void adminUpdateMember(MemberDTO dto) {
		sqlSession.update("admin.adminUpdateMember",dto);
		
	}

	@Override
	public int memberCount() {
		return sqlSession.selectOne("member.memberCount");
	}


	@Override
	public void onclickRestore(MemberDTO dto) {
		sqlSession.update("admin.onclickRestore",dto);
	}

	@Override
	public int withdrawalCount() {
		return sqlSession.selectOne("member.withdrawalCount");
	}

	@Override
	public List<MemberDTO> searchList(String search_option, String keyword) {
		Map<String,String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		if(search_option.equals("searchAll")) {
			return sqlSession.selectList("admin.searchAllList",map);
			
		}else {
			return sqlSession.selectList("admin.searchList",map);
		}
		
	}

	@Override
	public List<MemberDTO> withdrawalSearchList(String search_option, String keyword) {
		Map<String,String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		if(search_option.equals("searchAll")) {
			return sqlSession.selectList("admin.withdrawalAllList",map);
			
		}else {
			return sqlSession.selectList("admin.withdrawalSearchList",map);
		}
	}

	@Override
	public List<MemberDTO> list(Map<String, Object> map) {
		return sqlSession.selectList("member.list",map);
	}

	@Override
	public List<MemberDTO> withdrawalList(Map<String, Object> map) {
		return sqlSession.selectList("admin.withdrawalList",map);
	}

	@Override
	public MemberSessionDTO getMemberSession(String id) {
		return sqlSession.selectOne("member.getMemberSession", id);
	}
	
}
