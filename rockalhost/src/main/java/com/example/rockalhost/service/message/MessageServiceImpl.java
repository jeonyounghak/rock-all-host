package com.example.rockalhost.service.message;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.message.dao.MessageDAO;
import com.example.rockalhost.model.message.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	MessageDAO messageDao;
	
	@Override
	public List<MessageDTO> list(String nickName) {		
		return messageDao.list(nickName);
	}
	@Override
	public MessageDTO messageview(int idx) {
		return messageDao.messageview(idx);
	}
	@Override
	public void messageupdate(int idx) {
		messageDao.messageupdate(idx);
	}
	@Override
	public void messagewriter(String ninkName) {
		messageDao.messagewriter(ninkName);				
	}	
	@Override
	public void messageinsert(MessageDTO dto) throws Exception {
		messageDao.messageinsert(dto);	
	}
	@Override
	public void messagereply(MessageDTO dto) throws Exception {
		messageDao.messagereply(dto);	
	}
	@Override
	public List<MessageDTO> myList(String nickName) {
		return messageDao.myList(nickName);
	}
	@Override
	public MessageDTO myview(int idx) {
		return messageDao.myview(idx);
	}
	@Override
	public List<MessageDTO> receiverlist(String nickName) {		
		return messageDao.receiverlist(nickName);
	}
	@Override
	public void receiverupdate(int idx) {
		messageDao.receiverupdate(idx);
	}
}
