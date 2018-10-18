package com.example.rockalhost.service.recruit;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.recruit.dao.ReplyDAO;
import com.example.rockalhost.model.recruit.dto.ReplyDTO;


@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	ReplyDAO replyDao;

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
