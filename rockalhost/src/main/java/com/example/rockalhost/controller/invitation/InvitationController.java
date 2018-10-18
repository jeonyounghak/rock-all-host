package com.example.rockalhost.controller.invitation;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.email.dto.EmailDTO;
import com.example.rockalhost.model.invitation.dto.InvitationDTO;
import com.example.rockalhost.service.invitation.InvitationService;

@Controller
@RequestMapping("invitation/*")
public class InvitationController {
	
	@Inject
	InvitationService invitationService;
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session) throws Exception {
		String id = (String)session.getAttribute("id");
		List<InvitationDTO> list = invitationService.list(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/invitation/list");
		mav.addObject("list", list);
		System.out.println("list : "+list);
		return mav;
	}
	
	@RequestMapping("insert.do")
	public ModelAndView insert(@RequestParam int pf_idx, @RequestParam int count, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("id");
		
		if (id == null) {
			mav.setViewName("member/login");
			mav.addObject("message", "needLogin");
			return mav;
		}
		
		InvitationDTO dto = new InvitationDTO();
		dto.setUser_id(id);
		dto.setPf_idx(pf_idx);
		int doubleCheckCount = invitationService.doubleCheckCount(dto);
		
		
		if(doubleCheckCount != 0) {
			mav.setViewName("redirect:/performance/view/"+pf_idx);
			mav.addObject("message", "doubleInvi");
			
		} else {		
			Map<String, Object> map = new HashMap<>();
			map.put("pf_idx", pf_idx);
			map.put("id", id);
			map.put("count", count);
			invitationService.insert(map);
			
			mav.setViewName("redirect:/invitation/list.do");
		}
		
		return mav;
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(@RequestParam int iv_idx, @RequestParam int pf_idx, @RequestParam int count, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<>();
		map.put("iv_idx", iv_idx);
		map.put("pf_idx", pf_idx);
		map.put("count", count);
		
		invitationService.delete(map);
		
		mav.setViewName("redirect:/invitation/list.do");
		
		return mav;
	}
	
	@RequestMapping("email.do")
	public String send(@RequestParam int iv_idx, Model model, HttpSession session) {
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		String email = (String)session.getAttribute("email");
		
		System.out.println("iv_idx : "+iv_idx);
		
		InvitationDTO inviDto = new InvitationDTO();
		inviDto = invitationService.view(id);
		
		String user_id = inviDto.getUser_id();
		String pf_title = inviDto.getPf_title();
		String b_name = inviDto.getB_name();
		String pf_location = inviDto.getPf_location();
		Date pf_date = inviDto.getPf_date();
		String pf_time = inviDto.getPf_time();
		int count = inviDto.getCount();
		//String inviCode = inviDto.getInviCode();
		
		//String email = "lsl1117@naver.com";
		String subject = "[rockalhost] "+name+"("+user_id+")님 공연 초대장이 도착했습니다.";
		String message = "<div style=\"text-align: center;\"><br></div><div style=\"text-align: center;\">"
				+ "<br></div><table class=\"table table-bordered\"><tbody><tr><td>"
				+ "<div style=\"color: rgb(0, 0, 0); text-align: center;\"><br></div>"
				+ "<div style=\"color: rgb(0, 0, 0); text-align: center;\"><br></div>"
				+ "<div style=\"color: rgb(0, 0, 0); text-align: center;\"><br></div>"
				+ "<div style=\"color: rgb(0, 0, 0); text-align: center;\">공연 초대장이 도착했습니다.</div>"
				+ "<div><br></div><div style=\"text-align: center; \">"+name+"님께서 신청하신 "+pf_title+" 공연 초대장 "+count+"장을 발급해드립니다.</div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br>"
				+ "</div><div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \">"
				+ "<span style=\"background-color: rgb(255, 255, 255);\"><b><u>공연 안내</u></b></span></div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br>"
				+ "</div><div style=\"text-align: center; \"><table><tbody><tr><th>공연 타이틀 : "+pf_title+"</th></tr></tbody>"
				+ "</table></div><div style=\"text-align: center; \"><table><tbody><tr><th>밴드 이름 : "+b_name+"</th></tr>"
				+ "</tbody></table></div><div style=\"text-align: center; \"><table><tbody><tr><th>일시 : "+pf_date+" "+pf_time+"</th>"
				+ "</tr></tbody></table></div><div style=\"text-align: center; \"><table><tbody><tr><th>장소 : "+pf_location+"</th>"
				+ "</tr></tbody></table></div><div style=\"text-align: center; \"><table><tbody><tr><th>장수 : "+count+"장</th>"
				+ "</tr></tbody></table></div><div style=\"text-align: center; \"><table><tbody><tr><th>"
				+ "<table style=\"background-color: rgb(255, 255, 255);\">"
				+ "</table></th></tr></tbody></table></div><div style=\"text-align: center; \"><br></div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br></div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br></div>"
				+ "<div style=\"text-align: center; \">공연시작 30분 전에 도착해 안내에 따라 착석 해주시기 바랍니다.</div>"
				+ "<div style=\"text-align: center; \">공연에 부득이하게 참석하지 못 할 경우 초대장은 다른 분을 위해 홈페이지에서 삭제 처리 해주세요.</div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br></div>"
				+ "<div style=\"text-align: center; \"><br></div><div style=\"text-align: center; \"><br></div></td></tr></tbody>"
				+ "</table><div style=\"text-align: center;\"><br></div>";
		
		EmailDTO dto = new EmailDTO();
		dto.setSenderName("rockalhost_운영자");
		dto.setSenderMail("rockalhost@gmail.com");
		dto.setReceiveMail(email);
		dto.setSubject(subject);
		dto.setMessage(message);
		
		try {
			invitationService.sendMail(dto);
			invitationService.issued(iv_idx);
			model.addAttribute("message","susess");
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message","fail");
		}
		return "redirect:/invitation/list.do";
	}
	
}
