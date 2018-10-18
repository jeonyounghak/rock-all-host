package com.example.rockalhost.service.qna;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.qna.dao.QnaDAO;
import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Inject
	QnaDAO qnaDao;
	
	@Override
	public List<SubBoardDTO> list(Map<String, Integer> map) {
		return qnaDao.list(map);
	}
	@Override
	public void plusReadcount(int num, HttpSession session) {
		qnaDao.plusReadcount(num, session);
	}
	@Override
	public SubBoardDTO view(int num) {
		return qnaDao.view(num);
	}
	@Override
	public void insert(SubBoardDTO dto) {
		qnaDao.insert(dto);
	}
	@Override
	public boolean passwdCheck(SubBoardDTO dto) {
		return qnaDao.passwdCheck(dto);
	}
	@Override
	public void update(SubBoardDTO dto) {
		qnaDao.update(dto);
	}
	@Override
	public void hidden(SubBoardDTO dto) {
		qnaDao.hidden(dto);
	}
	@Override
	public void reply(SubBoardDTO dto) {
		qnaDao.reply(dto);
	}
	@Override
	public int getCount(int pf_idx) {
		return qnaDao.getCount(pf_idx);
	}
	
	
	@Override
	public int getBandQBCount(Map<String, Object> search_map) {
		return qnaDao.getBandQBCount(search_map);
	}
	@Override
	public List<SubBoardDTO> qbList(Map<String, Object> map) {
		return qnaDao.qbList(map);
	}
	@Override
	public int getAdminQBCount(Map<String, Object> search_map) {
		return qnaDao.getAdminQBCount(search_map);
	}
	@Override
	public List<SubBoardDTO> adminQBList(Map<String, Object> map) {
		return qnaDao.adminQBList(map);
	}


}
