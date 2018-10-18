package com.example.rockalhost.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.board.dao.BoardCommentDAO;
import com.example.rockalhost.model.board.dto.BoardCommentDTO;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	@Inject
	BoardCommentDAO boardCommentDao;
	
	@Override
	public List<BoardCommentDTO> list(int num) {
		return boardCommentDao.list(num);
	}
	@Override
	public void insert(BoardCommentDTO dto) {
		boardCommentDao.insert(dto);
	}
	@Override
	public void delete(int comment_num) {
		boardCommentDao.delete(comment_num);
	}
	@Override
	public BoardCommentDTO view(int comment_num) {
		return boardCommentDao.view(comment_num);
	}
	@Override
	public boolean passwdCheck(BoardCommentDTO dto) {
		return boardCommentDao.passwdCheck(dto);
	}

}
