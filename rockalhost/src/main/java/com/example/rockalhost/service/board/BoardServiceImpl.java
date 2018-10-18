package com.example.rockalhost.service.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.board.dao.BoardDAO;
import com.example.rockalhost.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> list(Map<String, Object> map) {
		return boardDao.list(map);
	}
	@Override
	public BoardDTO view(int num) {
		return boardDao.view(num);
	}
	@Override
	public void insert(BoardDTO dto) {
		boardDao.insert(dto);
	}
	@Override
	public boolean passwdCheck(BoardDTO dto) {
		return boardDao.passwdCheck(dto);
	}
	@Override
	public void hidden(BoardDTO dto) {
		boardDao.hidden(dto); 
	}
	@Override
	public void update(BoardDTO dto) {
		boardDao.update(dto);
	}
	@Override
	public void reply(BoardDTO dto) {
		boardDao.reply(dto);
	}
	@Override
	public void plusReadcount(int num, HttpSession session) {
		boardDao.plusReadcount(num, session);
	}
	@Override
	public int getCount(Map<String, String> count_map) {
		return boardDao.getCount(count_map);
	}
	@Override
	public int searchCount(Map<String, String> count_map) {
		return boardDao.searchCount(count_map);
	}
	
	
	@Override
	public int adminCount(Map<String, String> search_map) {
		return boardDao.adminCount(search_map);
	}
	@Override
	public List<BoardDTO> adminList(Map<String, Object> map) {
		return boardDao.adminList(map);
	}

}
