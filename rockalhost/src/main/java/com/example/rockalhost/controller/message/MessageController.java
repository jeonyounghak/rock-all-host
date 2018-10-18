package com.example.rockalhost.controller.message;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.message.dto.MessageDTO;
import com.example.rockalhost.service.message.MessageService;

@Controller
@RequestMapping("message/*")
public class MessageController {

	@Inject
	MessageService MessageService;
	
	@RequestMapping("messagelist.do")
	public ModelAndView list(MemberDTO dto, HttpSession session) throws Exception {
		System.out.println("messagelist.do 호출중...");
		String nickName = (String)session.getAttribute("nickName");
		dto.setNickName(nickName);
		System.out.println("닉네임="+nickName);
		List<MessageDTO> list = MessageService.list(nickName);
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("message/list");
		mav.addObject("map", map); 
		return mav; 
	}//list()
	@RequestMapping("receiverlist.do")
	public ModelAndView receiverlist(MemberDTO dto, HttpSession session) throws Exception {
		System.out.println("receiverlist.do 호출중...");
		String nickName = (String)session.getAttribute("nickName");
		dto.setNickName(nickName);
		System.out.println("닉네임="+nickName);
		List<MessageDTO> list = MessageService.receiverlist(nickName);
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("message/mymessage");
		mav.addObject("map", map); 
		return mav; 
	}//list()
	
	@RequestMapping("messageview.do")
	public String view(@RequestParam int idx, Model model) {
		System.out.println("messageview.do 호출중..");		
		model.addAttribute("dto", MessageService.messageview(idx));
		return "message/view";
	}
	
	@RequestMapping("messageupdate.do")
	public String update(int idx) throws Exception {
		System.out.println("messageupdate.do 호출중..");
		MessageService.messageupdate(idx);
		return "redirect:messagelist.do";
	}
	
	@RequestMapping("messagewriter.do")
	public String writer(@ModelAttribute MessageDTO dto, HttpSession session) throws Exception {
		System.out.println("messagewriter.do 호출중...");
		String sender = (String)session.getAttribute("nickName");
		dto.setSender(sender);
		System.out.println("닉네임="+sender);
		return "message/writer";
	}
	
	@RequestMapping("messageinsert.do")
	public String insert(@ModelAttribute MessageDTO dto, HttpSession session) throws Exception {
		System.out.println("messageinsert.do 호출중...");		
		MessageService.messageinsert(dto);
		return "redirect:messagelist.do";
	}	
	@RequestMapping("messagereplyview.do")
	public String replyview(@ModelAttribute MessageDTO dto, Model model) {
		System.out.println("messagereplyview.do 호출중...");		
		String sender = dto.getReceiver();
		String receiver = dto.getSender();
		dto.setSender(sender);
		dto.setReceiver(receiver);
		System.out.println("보내는이="+sender);		
		System.out.println("받는이="+receiver);
		model.addAttribute("dto", dto);
		return "message/reply";
	}
	@RequestMapping("messagereply.do")
	public String reply(@ModelAttribute MessageDTO dto, HttpSession session) throws Exception {
		System.out.println("messageinsert.do 호출중...");		
		MessageService.messagereply(dto);
		return "redirect:messagelist.do";
	}
	@RequestMapping("messagemy.do")
	public ModelAndView Mylist(MemberDTO dto, HttpSession session) throws Exception {
		System.out.println("Mylist.do 호출중...");
		String nickName = (String)session.getAttribute("nickName");
		dto.setNickName(nickName);
		System.out.println("닉네임="+nickName);
		List<MessageDTO> list = MessageService.myList(nickName);
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("message/mymessage");
		mav.addObject("map", map); 
		return mav; 
	}//mylist()
	@RequestMapping("myview.do")
	public String myview(@RequestParam int idx, Model model) {
		model.addAttribute("dto", MessageService.myview(idx));
		return "message/myview";
	}
	@RequestMapping("receiverupdate.do")
	public String receiverupdate(int idx) throws Exception {
		System.out.println("messageupdate.do 호출중..");
		MessageService.receiverupdate(idx);
		return "redirect:messagelist.do";
	}
}

