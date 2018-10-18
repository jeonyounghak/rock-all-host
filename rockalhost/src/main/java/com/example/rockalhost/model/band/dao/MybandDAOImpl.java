package com.example.rockalhost.model.band.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.band.dto.MybandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;


@Repository
public class MybandDAOImpl implements MybandDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MybandDTO> list(int band) {
		return sqlSession.selectList("band.mylist", band);
	}
	@Override
	public List<MybandDTO> leaderlist(int band) {
		return sqlSession.selectList("band.leaderlist", band);
	}
	@Override
	public MemberDTO temperProfile(String nickName) {
		return sqlSession.selectOne("band.temperProfile", nickName);
	}
	@Override
	public void temperUpdate(MemberDTO dto) {
		sqlSession.update("band.temperUpdate", dto);		
	}
	@Override
	public void temperDelete(MemberDTO dto) {
		sqlSession.update("band.temperDelete", dto);		
	}
	@Override
	public void mytemperDelete(MemberDTO dto) {
		sqlSession.update("band.mytemperDelete", dto);		
	}
	@Override
	public void adminBandDelete(MemberDTO dto) {
		sqlSession.update("admin.adminBandDelete", dto);
		sqlSession.update("admin.adminBandShow", dto);
	}
}
