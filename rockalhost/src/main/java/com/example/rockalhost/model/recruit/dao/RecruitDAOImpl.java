package com.example.rockalhost.model.recruit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.recruit.dto.ApplDTO;
import com.example.rockalhost.model.recruit.dto.RecruitDTO;
import com.example.rockalhost.model.recruit.dto.ViewMemberDTO;

@Repository
public class RecruitDAOImpl implements RecruitDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<RecruitDTO> list(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("recruit.list",map);
	}

	@Override
	public RecruitDTO view(int idx) {
		return sqlSession.selectOne("recruit.view", idx);
	}


	@Override
	public void create(RecruitDTO dto) {
		sqlSession.insert("recruit.insert", dto);
		
	}

	@Override
	public void addattach(String fullName) {
		sqlSession.insert("recruit.addAttach", fullName);		
	}

	@Override
	public void appl(ApplDTO dto) {
		sqlSession.insert("recruit.appl", dto);
		
	}

	@Override
	public List<MemberDTO> check_list(int idx) {
		return sqlSession.selectList("recruit.check_list", idx);
	}

	@Override
	public ViewMemberDTO profile(String writer) {
		return sqlSession.selectOne("recruit.profile", writer);
	}

	@Override
	public void appr(String id, int idx, int band, String nickName) {
		sqlSession.update("recruit.appr", id);
		sqlSession.update("recruit.grade", id);
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("band", band);
		map.put("nickName", nickName);
		sqlSession.update("recruit.b_num", map);
		sqlSession.update("recruit.myBand", map);
	}

	@Override
	public void recommend(RecruitDTO dto) {
		sqlSession.insert("recruit.recommend",dto);
		
	}

	@Override
	public AllbandDTO band_profile(String writer) {
		return sqlSession.selectOne("recruit.band_profile", writer);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("recruit.countArticle");
	}

	@Override
	public String appl_check(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		return sqlSession.selectOne("recruit.appl_check",map);
	}

	@Override
	public void readCount(int idx) {
		sqlSession.update("recruit.readCount",idx);
		
	}

	@Override
	public void update(RecruitDTO dto) {
		sqlSession.update("recruit.update",dto);
	}

	@Override
	public void delete(int idx) {
		sqlSession.update("recruit.delete",idx);
	}

	@Override
	public int grade_check(String id) {
		return sqlSession.selectOne("recruit.grade_check",id);
	}

	@Override
	public String check_recommend(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		return sqlSession.selectOne("recruit.check_recommend", map);
	}

	@Override
	public void delete_recommend(String id, int idx) {
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("idx", idx);
		sqlSession.delete("recruit.delete_recommend", map);
	}

	@Override
	public void close(int idx) {
		sqlSession.update("recruit.close", idx);
	}

}
