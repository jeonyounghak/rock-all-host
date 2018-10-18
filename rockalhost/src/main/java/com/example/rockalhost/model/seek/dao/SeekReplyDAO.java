package com.example.rockalhost.model.seek.dao;

import java.util.List;

import com.example.rockalhost.model.seek.dto.ReplyDTO;

public interface SeekReplyDAO {
	public List<ReplyDTO> list(int idx);
	public void create(ReplyDTO dto);

}
