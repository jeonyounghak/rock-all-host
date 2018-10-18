package com.example.rockalhost.controller.recruit;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rockalhost.model.recruit.dto.ReplyDTO;
import com.example.rockalhost.service.recruit.ReplyService;

@RestController 
@RequestMapping("reply/*") 
public class ReplyController {
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(ReplyDTO dto, HttpSession session) {
		String nickName=(String)session.getAttribute("nickName");
		dto.setReplyer(nickName);
		System.out.println(dto);
		replyService.create(dto);
	}

	@RequestMapping("list_json.do")
	public List<ReplyDTO> list_json(int idx){
		return replyService.list(idx);
	}

}
