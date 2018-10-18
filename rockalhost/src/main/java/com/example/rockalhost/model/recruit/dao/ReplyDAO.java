package com.example.rockalhost.model.recruit.dao;

import java.util.List;

import com.example.rockalhost.model.recruit.dto.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> list(int idx);
	public void create(ReplyDTO dto);

}
