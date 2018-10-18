package com.example.rockalhost.controller.seek;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.seek.dto.ApplDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.service.recruit.Pager;
import com.example.rockalhost.service.seek.SeekService;

@Controller
@RequestMapping("seek/*")
public class seekController {
	
	@Inject
	SeekService seekService;
	
	@RequestMapping("list.do")
	public ModelAndView list(
			@RequestParam(defaultValue="writer") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		System.out.println("keyword="+keyword);
		int count = seekService.countArticle(search_option,keyword);
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<SeekDTO> list = seekService.list(search_option,keyword,start,end);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		mav.setViewName("seek/list");
		/*mav.setViewName("/");*/
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("view/{idx}")
	public ModelAndView detail(@PathVariable int idx, ModelAndView mav, HttpSession session) {
		seekService.readCount(idx,session);
		String id=(String)session.getAttribute("id");
		if(id==null) {
			mav.setViewName("seek/view");
			mav.addObject("dto", seekService.view(idx));
			return mav;
		}else {
			String result = seekService.check_recommend(id,idx);
			if(result == null) {
				mav.setViewName("seek/view");
				mav.addObject("dto", seekService.view(idx));
				mav.addObject("message2","success");
			}else {
				mav.setViewName("seek/view");
				mav.addObject("dto", seekService.view(idx));
				mav.addObject("message2","fail");
			}
			return mav;
		}
	}
	
	@RequestMapping("grade_check.do")
	public ModelAndView grade_check(HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = seekService.grade_check(id);
		ModelAndView mav = new ModelAndView();
		if(result == 1) {
			mav.setViewName("seek/write");		
		}else {
			mav.setViewName("redirect:/seek/list.do");
			mav.addObject("message","fail");
		}
		return mav;		
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute SeekDTO dto, HttpSession session)throws Exception {
		String writer=(String)session.getAttribute("nickName");
		dto.setWriter(writer);
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
           ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        seekService.create(dto);
		return "redirect:/seek/list.do";
	}
	
	@RequestMapping("appl_check.do")
	public ModelAndView appl_check(HttpSession session, int idx) {
		String id = (String)session.getAttribute("id");
		String result = seekService.appl_check(id,idx);
		System.out.println("result="+result);
		ModelAndView mav = new ModelAndView();
		if(result == null) {			
			mav.setViewName("redirect:/seek/appl.do");
			mav.addObject("idx",idx);
		}else {			
			mav.setViewName("seek/view");
			mav.addObject("dto", seekService.view(idx));
			mav.addObject("message","fail");
		}
		return mav;
	}
	
	@RequestMapping("appl.do")
	public String appl(@ModelAttribute ApplDTO dto, HttpSession session, int idx) {
		System.out.println("idx"+idx);
		String id=(String)session.getAttribute("id");
		dto.setId(id);
		dto.setIdx(idx);
		seekService.appl(dto);
		return "redirect:/seek/view/"+idx;
	}
	
	@RequestMapping("check/{idx}")
	public ModelAndView check_list(@PathVariable int idx) {
		System.out.println("idx="+idx);
		List<MemberDTO> list = seekService.check_list(idx);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("idx", idx);
		mav.setViewName("seek/check_list");
		mav.addObject("map", map);
		//System.out.println("num="+num);
		return mav;
	}
	
	@RequestMapping("profile/{writer}")
	public ModelAndView profile(ModelAndView mav,@PathVariable String writer) {
		System.out.println("writer="+writer);
		mav.setViewName("seek/normal_profile");
		mav.addObject("dto", seekService.profile(writer));
		return mav;
	}
	
	@RequestMapping("appr.do")
	public String appr(@RequestParam String id, int idx) {
		System.out.println("idx="+idx);
		System.out.println("id="+id);
		seekService.appr(id,idx);
		return "redirect:/seek/check/"+idx;
	}
	
	@RequestMapping("recommend/{idx}")
	public String recommend(HttpSession session, @PathVariable int idx) {
		SeekDTO dto = new SeekDTO();
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		dto.setIdx(idx);
		System.out.println("dto은..."+dto);
		seekService.recommend(dto);
		return "redirect:/seek/view/"+idx;
	}
	
	@RequestMapping("normal_profile.do")
	public ModelAndView n_profile(ModelAndView mav, String writer) {
		System.out.println("writer.."+writer);
		mav.setViewName("seek/normal_profile");
		mav.addObject("dto", seekService.profile(writer));
		return mav;
	}
	
	@RequestMapping("edit.do")
	public ModelAndView write(ModelAndView mav, int idx) {
		mav.setViewName("seek/edit");
		mav.addObject("dto", seekService.view(idx));
		return mav;		
	}
	
	@RequestMapping("update.do")
	public String update(SeekDTO dto, int idx) {
		dto.setIdx(idx);
		seekService.update(dto);
		return "redirect:/seek/view/"+dto.getIdx();
	}
	
	@RequestMapping("delete.do")
	public String delete(int idx) {
		seekService.delete(idx);
		return "redirect:/seek/list.do";
	}
	
	@RequestMapping("delete_recommend/{idx}")
	public String delete_recommend(HttpSession session, @PathVariable int idx) {
		String id = (String)session.getAttribute("id");
		seekService.delete_recommend(id,idx);
		return "redirect:/seek/view/"+idx;
	}

}
