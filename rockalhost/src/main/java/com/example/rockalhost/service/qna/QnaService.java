package com.example.rockalhost.service.qna;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;


public interface QnaService {
	
	public List<SubBoardDTO> list(Map<String, Integer> map);
	public void plusReadcount(int num, HttpSession session);
	public SubBoardDTO view(int num);
	public void insert(SubBoardDTO dto);
	public boolean passwdCheck(SubBoardDTO dto);
	public void update(SubBoardDTO dto);
	public void hidden(SubBoardDTO dto);
	public void reply(SubBoardDTO dto);
	public int getCount(int pf_idx);
	
	public int getBandQBCount(Map<String, Object> search_map);
	public List<SubBoardDTO> qbList(Map<String, Object> map);
	public int getAdminQBCount(Map<String, Object> search_map);
	public List<SubBoardDTO> adminQBList(Map<String, Object> map);

}
