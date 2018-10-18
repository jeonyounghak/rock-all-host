package com.example.rockalhost.model.invitation.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.invitation.dto.InvitationDTO;

@Repository
public class InvitationDAOImpl implements InvitationDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(InvitationDTO dto) {
		sqlSession.insert("invitation.insert", dto);
	}

	@Override
	public List<InvitationDTO> list(String id) {
		return sqlSession.selectList("invitation.list", id);
	}

	@Override
	public int doubleCheckCount(InvitationDTO dto) {
		return sqlSession.selectOne("invitation.doubleCheckCount", dto);
	}

	@Override
	public void delete(int iv_idx) {
		sqlSession.delete("invitation.delete", iv_idx);	
	}

	@Override
	public InvitationDTO view(String id) {
		return sqlSession.selectOne("invitation.view", id);
	}

	@Override
	public void issued(int iv_idx) {
		sqlSession.update("invitation.issued", iv_idx);
	}

	@Override
	public List<InvitationDTO> getIv_idxList(int pf_idx) {
		return sqlSession.selectList("invitation.getIv_idxList", pf_idx);
	}

	@Override
	public void deleteAll(InvitationDTO dto) {
		sqlSession.delete("invitation.deleteAll", dto);	
	}
	

}
