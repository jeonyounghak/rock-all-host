package com.example.rockalhost.service.review;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.review.dao.ReviewDAO;
import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;
import com.example.rockalhost.model.subBoardComment.dto.SubBoardCommentDTO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	ReviewDAO reviewDao;
	
	@Override
	public List<SubBoardDTO> list(Map<String, Integer> map) {
		return reviewDao.list(map);
	}
	@Override
	public void plusReadcount(int num, HttpSession session) {
		reviewDao.plusReadcount(num, session);
	}
	@Override
	public SubBoardDTO view(int num) {
		return reviewDao.view(num);
	}
	@Override
	public void insert(SubBoardDTO dto) {
		reviewDao.insert(dto);
	}
	@Override
	public boolean passwdCheck(SubBoardDTO dto) {
		return reviewDao.passwdCheck(dto);
	}
	@Override
	public void update(SubBoardDTO dto) {
		reviewDao.update(dto);
	}
	@Override
	public void hidden(SubBoardDTO dto) {
		reviewDao.hidden(dto);
	}
	@Override
	public int getCount(int pf_idx) {
		return reviewDao.getCount(pf_idx);
	}
	
	
	
	@Override
	public List<SubBoardCommentDTO> commentList(int num) {
		return reviewDao.commentList(num);
	}
	@Override
	public void commentInsert(SubBoardCommentDTO dto) {
		reviewDao.commentInsert(dto);
	}
	@Override
	public SubBoardCommentDTO commentView(int comment_num) {
		return reviewDao.commentView(comment_num);
	}
	@Override
	public boolean commentPasswdCheck(SubBoardCommentDTO dto) {
		return reviewDao.commentPasswdCheck(dto);
	}
	@Override
	public void commentDelete(int comment_num) {
		reviewDao.commentDelete(comment_num);
	}
	
	
	@Override
	public int getBandRBCount(Map<String, Object> search_map) {
		return reviewDao.getBandRBCount(search_map);
	}
	@Override
	public List<SubBoardDTO> rbList(Map<String, Object> map) {
		return reviewDao.rbList(map);
	}
	
	
	@Override
	public int getAdminCount(Map<String, String> search_map) {
		return reviewDao.getAdminCount(search_map);
	}
	@Override
	public List<SubBoardDTO> adminList(Map<String, Object> map) {
		return reviewDao.adminList(map);
	}


}
