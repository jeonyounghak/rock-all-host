package com.example.rockalhost.model.seek.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.seek.dto.ApplDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.model.seek.dto.ViewMemberDTO;


@Repository
public class SeekDAOImpl implements SeekDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<SeekDTO> list(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("seek.list",map);
	}

	@Override
	public SeekDTO view(int idx) {
		return sqlSession.selectOne("seek.view", idx);
	}


	@Override
	public void create(SeekDTO dto) {
		sqlSession.insert("seek.insert", dto);
		
	}

	@Override
	public void addattach(String fullName) {
		sqlSession.insert("seek.addAttach", fullName);		
	}

	@Override
	public void appl(ApplDTO dto) {
		sqlSession.insert("seek.appl", dto);
		
	}

	@Override
	public List<MemberDTO> check_list(int idx) {
		return sqlSession.selectList("seek.check_list", idx);
	}

	@Override
	public ViewMemberDTO profile(String writer) {
		return sqlSession.selectOne("seek.profile", writer);
	}

	@Override
	public void appr(String id, int idx) {
		sqlSession.update("seek.appr", id);
		
	}

	@Override
	public void recommend(SeekDTO dto) {
		sqlSession.insert("seek.recommend",dto);
		
	}

	@Override
	public AllbandDTO band_profile(String writer) {
		return sqlSession.selectOne("seek.band_profile", writer);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("seek.countArticle");
	}

	@Override
	public String appl_check(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		return sqlSession.selectOne("seek.appl_check",map);
	}

	@Override
	public void readCount(int idx) {
		sqlSession.update("seek.readCount",idx);
		
	}

	@Override
	public void update(SeekDTO dto) {
		sqlSession.update("seek.update",dto);
	}

	@Override
	public void delete(int idx) {
		sqlSession.update("seek.delete",idx);
	}

	@Override
	public int grade_check(String id) {
		return sqlSession.selectOne("seek.grade_check",id);
	}

	@Override
	public String check_recommend(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		return sqlSession.selectOne("seek.check_recommend", map);
	}

	@Override
	public void delete_recommend(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		sqlSession.delete("seek.delete_recommend", map);
	}

}
