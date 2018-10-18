package com.example.rockalhost.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.service.member.MemberService;
import com.example.rockalhost.util.BCrypt;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "member/main_login";
	}
	
	@RequestMapping("preJoin.do")
	public String join() {
		return "member/pre_join";
	}
	
	@RequestMapping("join.do")
	public String input() {
		return "member/join";
	}
	@RequestMapping("insert.do")
	public ModelAndView insert(@ModelAttribute MemberDTO dto) {
		String passwd = BCrypt.hashpw(dto.getPasswd(), BCrypt.gensalt());
		dto.setPasswd(passwd);
		memberService.insert(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("message", "success");
		return mav;
	}
	
/*	@RequestMapping("login_check.do")
	public ModelAndView loginCheck(MemberDTO dto, HttpSession session) {
		System.out.println("login_check.do 호출");
		boolean result = memberService.loginCheck(dto, session);

		System.out.println("result:"+result);
		ModelAndView mav = new ModelAndView();
		if(result) {
			mav.setViewName("home");
		}else {
			mav.setViewName("member/main_login");
			mav.addObject("message", "error");
		}
		return mav;
	}*/
	
	//테스트
	@RequestMapping("login_check.do")
	public ModelAndView loginCheck(MemberDTO dto, HttpSession session) {
		System.out.println("login_check.do 호출 테스트");		
		String name = memberService.loginCheck(dto, session);
		System.out.println("login_check.do 호출 테스트 name: "+name);
		ModelAndView mav = new ModelAndView();
		if(name != "" && name != null) {
			mav.setViewName("home");
		
		}else {
			mav.setViewName("member/main_login");
			mav.addObject("message", "error");
		}
		
		return mav;
	}
	
	
	@RequestMapping("logout.do")
	public ModelAndView logout (HttpSession session, ModelAndView mav) {
		memberService.logout(session);
		mav.setViewName("home");
		mav.addObject("message", "logout");
		return mav;	
	}

	@RequestMapping("view.do")
	public ModelAndView view(ModelAndView mav, HttpSession session) {
		String id = (String)session.getAttribute("id");
		System.out.println("view.do 호출");
		mav.setViewName("/member/view");
		mav.addObject("dto", memberService.viewMember(id));
		return mav;
	}
	
	@RequestMapping("edit.do")
	public ModelAndView edit(HttpServletRequest request, ModelAndView mav, HttpSession session) {
		System.out.println("edit.do 호출");
		/*String name = null;*/
		String id = (String)session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		/*MemberDTO dto = memberService.viewMember(id);
		String bcryptPasswd = dto.getPasswd();
			if(BCrypt.checkpw(bcryptPasswd, passwd)) {
			name = dto.getName();
			}else {
				name = null;
			}*/
		MemberDTO dto = new MemberDTO(); 
		dto.setId(id);
		dto.setPasswd(passwd);
		String name = memberService.loginCheck(dto, session);
		if(name != null) {
			mav.addObject("dto", memberService.viewMember(id));
			mav.setViewName("/member/edit");
			return mav;
		}else {
			mav.setViewName("/member/view");
			mav.addObject("dto", memberService.viewMember(id));
			mav.addObject("message", "fail");
			return mav;
		}
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(String id, String passwd, ModelAndView mav, HttpSession session) {
		System.out.println("delete.do 호출");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPasswd(passwd);
	     
		String name = memberService.loginCheck(dto, session);
	
		if(name != null) {
			memberService.delete(id);
			session.invalidate();
			mav.setViewName("home");
			mav.addObject("message", "bye");
			return mav;
		}else {
			mav.setViewName("/member/edit");
			mav.addObject("dto", memberService.viewMember(id));
			mav.addObject("message", "fail");	
			return mav;
		}
	}
	
	@RequestMapping("withdrawal.do")
	public ModelAndView withdrawal(String id, String passwd, ModelAndView mav, HttpSession session) {
		System.out.println("delete.do 호출");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPasswd(passwd);
	     
		String name = memberService.loginCheck(dto, session);
	
		if(name != null) {
			memberService.withdrawal(id);
			session.invalidate();
			mav.setViewName("home");
			mav.addObject("message", "bye");
			return mav;
		}else {
			mav.setViewName("/member/edit");
			mav.addObject("dto", memberService.viewMember(id));
			mav.addObject("message", "fail");	
			return mav;
		}
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(MemberDTO dto, ModelAndView mav, HttpSession session) {
		System.out.println("update.do 호출");
        String passwd = BCrypt.hashpw(dto.getPasswd(), BCrypt.gensalt());
        dto.setPasswd(passwd);
		System.out.println("String passwd:"+passwd);
		memberService.updateMember(dto);
		System.out.println("updateMember dto:"+dto);
		session.setAttribute("nickName", dto.getNickName());
		mav.addObject("message", "update");
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping("passwdUpdate.do")
	public ModelAndView passwdUpdate(MemberDTO dto, ModelAndView mav) {
		System.out.println("passwdUpdate.do 호출");
		String passwd = BCrypt.hashpw(dto.getPasswd(), BCrypt.gensalt());
	    dto.setPasswd(passwd);
		memberService.passwdUpdate(dto);
		
		mav.setViewName("home");
		mav.addObject("message", "passwdUpdate");
		return mav;
	}
	
	@RequestMapping("nickCheck.do")
	public ModelAndView nickCheck(MemberDTO dto, String nickName , ModelAndView mav) {
		System.out.println("nickCheck.do 호출");
		boolean result = memberService.nickCheck(nickName);
		if(result) {
			mav.setViewName("/member/edit");
			mav.addObject("dto", memberService.viewMember(dto.getId()));
			mav.addObject("nickName", nickName);
			mav.addObject("message", "possible");
			return mav;
		}else {
			mav.setViewName("/member/edit");
			mav.addObject("dto", memberService.viewMember(dto.getId()));
			mav.addObject("message", "impossible");
			return mav;
		}
	}
	
	@RequestMapping("popup_checkNick/{nickName}")
	public ModelAndView popNickCheck(@PathVariable String nickName, ModelAndView mav) {
		mav.addObject("nickName", nickName);
		mav.setViewName("member/checkNick");
		return mav;
	}

	
	@RequestMapping("popup_checkId/{id}")
	public ModelAndView popIdCheck(@PathVariable String id, ModelAndView mav) {
		System.out.println("popup_checkId.do id:"+id);
		mav.setViewName("member/checkId");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("popNickCheck.do")
	public ModelAndView checkNick(String nickName) {
		System.out.println("checkNick.do 호출");
		boolean result = memberService.join_nickCheck(nickName);
		System.out.println("checkNick.do result:"+result);
		    ModelAndView mav = new ModelAndView();
		if(result) {
			mav.setViewName("member/checkNick");
			mav.addObject("nickName", nickName);
			mav.addObject("message", "possible");    
		}else {
			mav.setViewName("member/checkNick");
			mav.addObject("message", "impossible");  	
		}
		return mav;
	}	
	
	@RequestMapping("popIdCheck.do")
	public ModelAndView checkId(String id) {
		System.out.println("checkId.do 호출");
		boolean result = memberService.join_idCheck(id);
		System.out.println("checkId.do result:"+result);
		    ModelAndView mav = new ModelAndView();
		if(result) {
			mav.setViewName("member/checkId");
			mav.addObject("id", id);
			mav.addObject("message", "possible");    
		}else {
			mav.setViewName("member/checkId");
			mav.addObject("message", "impossible");  	
		}
		return mav;
	}
	@RequestMapping("findIdPage.do")
	public String FindIdPage() {
		return "member/findId";
	}
	
	@RequestMapping("findId.do")
	public ModelAndView findId(HttpServletRequest request, ModelAndView mav) {
		System.out.println("findId.do 호출");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		String id = memberService.idFind(map);
		System.out.println("findId.do userid:"+id);
		
		if(id != null) {
			mav.setViewName("member/find_result");
			mav.addObject("id", id);
			mav.addObject("message", "find");
			
		}else {
			mav.setViewName("member/findId");
			mav.addObject("message", "fail");
		}
		return mav;
	}
	
	@RequestMapping("findPasswdPage.do")
	public String FindPasswdPage() {
		return "member/findPasswd";
	}
	
	@RequestMapping("findpasswd.do")
	public ModelAndView findPasswd(HttpServletRequest request, ModelAndView mav) {
		System.out.println("findpasswd.do 호출");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		String passwd = memberService.passwdFind(map);
		
		if(passwd != null) {
			mav.setViewName("member/find_result_passwd");
			mav.addObject("message", "find");
			mav.addObject("id",id);
			
		}else {
			mav.setViewName("member/findPasswd");
			mav.addObject("message", "fail");
		}
		return mav;
	}
	
	
	/*@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		System.out.println("list.do 호출");
		List<MemberDTO> list = memberService.list();
		mav.setViewName("admin/member/list");
		mav.addObject("list",list);
		return mav;
	}*/
	
	@RequestMapping("listView/{id}")
	public ModelAndView listView(@PathVariable String id, ModelAndView mav) {
		System.out.println("listView/{id} 호출");
		mav.addObject("dto", memberService.viewMember(id));
		mav.setViewName("member/edit");
		return mav;
	}
	
	
	
}
