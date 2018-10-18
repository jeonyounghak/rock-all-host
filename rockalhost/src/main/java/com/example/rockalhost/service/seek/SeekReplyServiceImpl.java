package com.example.rockalhost.service.seek;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.seek.dao.SeekReplyDAO;
import com.example.rockalhost.model.seek.dto.ReplyDTO;


@Service
public class SeekReplyServiceImpl implements SeekReplyService {
	@Inject
	SeekReplyDAO replyDao;

	@Override
	public List<ReplyDTO> list(int idx) {
		return replyDao.list(idx);
	}

	//댓글 쓰기
	@Override
	public void create(ReplyDTO dto) {
		replyDao.create(dto);
	}

}
