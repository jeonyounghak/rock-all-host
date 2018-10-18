package com.example.rockalhost.model.message.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.rockalhost.model.message.dto.MessageDTO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MessageDTO> list(String nickName) {
		return sqlSession.selectList("message.messagelist", nickName);	
	}
	@Override
	public MessageDTO messageview(int idx) {
		return sqlSession.selectOne("message.messageview", idx);
	}
	@Override
	public void messageupdate(int idx) {
		sqlSession.update("message.messageupdate", idx);
	}
	@Override
	public void messagewriter(String ninkName) {
		sqlSession.selectOne(ninkName);				
	}	
	@Override
	public void messageinsert(MessageDTO dto) throws Exception {
		sqlSession.insert("message.messageinsert", dto);
	}
	@Override
	public void messagereply(MessageDTO dto) throws Exception {
		sqlSession.insert("message.messagereply", dto);
	}
	@Override
	public List<MessageDTO> myList(String nickName) {
		return sqlSession.selectList("message.myList", nickName);	
	}
	@Override
	public MessageDTO myview(int idx) {
		return sqlSession.selectOne("message.myview", idx);
	}
	@Override
	public List<MessageDTO> receiverlist(String nickName) {
		return sqlSession.selectList("message.receiverlist", nickName);	
	}
	@Override
	public void receiverupdate(int idx) {
		sqlSession.update("message.receiverupdate", idx);
	}
}
