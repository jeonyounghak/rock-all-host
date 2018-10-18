package com.example.rockalhost.service.seek;

import java.util.List;

import com.example.rockalhost.model.seek.dto.ReplyDTO;


public interface SeekReplyService {
	
	public List<ReplyDTO> list(int idx);
	public void create(ReplyDTO dto);

}
