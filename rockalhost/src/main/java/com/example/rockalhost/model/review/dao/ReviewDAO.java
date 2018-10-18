package com.example.rockalhost.model.review.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;
import com.example.rockalhost.model.subBoardComment.dto.SubBoardCommentDTO;

public interface ReviewDAO {

	public List<SubBoardDTO> list(Map<String, Integer> map);
	public void plusReadcount(int num, HttpSession session);
	public SubBoardDTO view(int num);
	public void insert(SubBoardDTO dto);
	public boolean passwdCheck(SubBoardDTO dto);
	public void update(SubBoardDTO dto);
	public void hidden(SubBoardDTO dto);
	
	public List<SubBoardCommentDTO> commentList(int num);
	public void commentInsert(SubBoardCommentDTO dto);
	public SubBoardCommentDTO commentView(int comment_num);
	public boolean commentPasswdCheck(SubBoardCommentDTO dto);
	public void commentDelete(int comment_num);
	public int getCount(int pf_idx);
	
	public int getBandRBCount(Map<String, Object> search_map);
	public List<SubBoardDTO> rbList(Map<String, Object> map);
	
	public int getAdminCount(Map<String, String> search_map);
	public List<SubBoardDTO> adminList(Map<String, Object> map);

}
