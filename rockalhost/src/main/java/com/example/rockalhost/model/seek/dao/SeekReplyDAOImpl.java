package com.example.rockalhost.model.seek.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.seek.dto.ReplyDTO;


@Repository
public class SeekReplyDAOImpl implements SeekReplyDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<ReplyDTO> list(int idx) {
		return sqlSession.selectList("seekreply.listReply", idx);
	}

	@Override
	public void create(ReplyDTO dto) {
		sqlSession.insert("seekreply.insertReply", dto);

	}

}
