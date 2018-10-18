package com.example.rockalhost.service.message;

import java.util.List;

import com.example.rockalhost.model.message.dto.MessageDTO;

public interface MessageService {
	
	public List<MessageDTO> list(String nickName);
	public MessageDTO messageview(int idx);	
	public void messageupdate(int idx);
	public void messagewriter(String ninkName);	
	public void messageinsert(MessageDTO dto) throws Exception;
	public void messagereply(MessageDTO dto) throws Exception;
	public List<MessageDTO> myList(String nickName);
	public MessageDTO myview(int idx);
	public List<MessageDTO> receiverlist(String nickName);
	public void receiverupdate(int idx);	

}
