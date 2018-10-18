package com.example.rockalhost.service.recruit;

import java.util.List;

import com.example.rockalhost.model.recruit.dto.ReplyDTO;

public interface ReplyService {
	
	public List<ReplyDTO> list(int idx);
	public void create(ReplyDTO dto);

}
