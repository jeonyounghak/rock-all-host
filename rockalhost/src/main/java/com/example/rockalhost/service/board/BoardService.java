package com.example.rockalhost.service.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.board.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list(Map<String, Object> map);
	public BoardDTO view(int num);
	public void insert(BoardDTO dto);
	public boolean passwdCheck(BoardDTO dto);
	public void hidden(BoardDTO dto);
	public void update(BoardDTO dto);
	public void reply(BoardDTO dto);
	public void plusReadcount(int num, HttpSession session);
	public int getCount(Map<String, String> count_map);
	public int searchCount(Map<String, String> count_map);
	
	public int adminCount(Map<String, String> search_map);
	public List<BoardDTO> adminList(Map<String, Object> map);

}
