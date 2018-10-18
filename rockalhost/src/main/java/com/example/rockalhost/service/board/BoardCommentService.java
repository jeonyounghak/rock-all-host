package com.example.rockalhost.service.board;

import java.util.List;

import com.example.rockalhost.model.board.dto.BoardCommentDTO;

public interface BoardCommentService {

	public List<BoardCommentDTO> list(int num);
	public void insert(BoardCommentDTO dto);
	public void delete(int comment_num);
	public BoardCommentDTO view(int comment_num);
	public boolean passwdCheck(BoardCommentDTO dto);

}
