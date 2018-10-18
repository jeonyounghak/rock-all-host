package com.example.rockalhost.model.admin.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.admin.dto.AdminDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(AdminDTO dto) {
		String name = sqlSession.selectOne("admin.login_check", dto);
		return (name == null) ? false : true ;
	}

	@Override
	public AdminDTO view(String id) {
		return sqlSession.selectOne("admin.viewMember", id);
	}
	
}
