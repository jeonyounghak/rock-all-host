package com.example.rockalhost.model.band.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.band.dto.AllbandViewDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;

@Repository
public class AllbandDAOImpl implements AllbandDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<AllbandViewDTO> list(Map<String, Object> map) {
		return sqlSession.selectList("admin.bandList", map);
	}
	@Override
	public void apply(AllbandDTO dto) throws Exception {
		sqlSession.insert("band.apply", dto);
		sqlSession.update("band.userapply", dto);
	}
	@Override
	public void applyview(String nickName) {
		sqlSession.selectOne(nickName);				
	}	
	@Override
	public List<MemberDTO> adminlist(int idx) {
		return sqlSession.selectList("admin.adminlist");
	}
	@Override
	public List<AllbandViewDTO> applylist() {
		return sqlSession.selectList("admin.applylist");
	}
	@Override
	public void adminapply(AllbandDTO dto) throws Exception {
		sqlSession.update("admin.adminapply", dto);
	}
	@Override
	public AllbandViewDTO applyshow(String nickName) {
		return sqlSession.selectOne("admin.applyshow",nickName);
	}
	@Override
	public AllbandViewDTO mybandview(int b_idx) {
		return sqlSession.selectOne("band.mybandview", b_idx);
	}
	@Override
	public void mybandupdate(AllbandDTO dto) {
		sqlSession.update("band.mybandupdate", dto);
	}
	@Override
	public MemberDTO memberview(String nickName) {
		return sqlSession.selectOne("band.memberview", nickName);
	}
	@Override
	public boolean join_idCheck(String b_name) {
		boolean result = false;
		int count = sqlSession.selectOne("band.joinIdCheck", b_name);
		if(count == 0) result = true;
		return result;
	}
	@Override
	public int bandCount() {
		return sqlSession.selectOne("band.bandCount");
	}
	@Override
	public List<AllbandViewDTO> searchList(String search_option, String keyword) {
		Map<String,String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		if(search_option.equals("searchAll")) {
			return sqlSession.selectList("admin.bandsearchAllList",map);
			
		}else {
			return sqlSession.selectList("admin.bandsearchList",map);
		}
		
	}
	
	@Override
	public int getCheckNick(String b_leaderNick) {
		return sqlSession.selectOne("band.getCheckNick", b_leaderNick);
	}
	
}
