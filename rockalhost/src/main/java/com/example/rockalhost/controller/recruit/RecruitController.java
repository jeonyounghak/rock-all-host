package com.example.rockalhost.controller.recruit;


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
import com.example.rockalhost.model.recruit.dto.ApplDTO;
import com.example.rockalhost.model.recruit.dto.RecruitDTO;
import com.example.rockalhost.service.recruit.Pager;
import com.example.rockalhost.service.recruit.RecruitService;

@Controller
@RequestMapping("recruit/*")
public class RecruitController {
	
	@Inject
	RecruitService recruitService;
	
	@RequestMapping("list.do")
	public ModelAndView list(
			@RequestParam(defaultValue="writer") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		System.out.println("keyword="+keyword);
		int count = recruitService.countArticle(search_option,keyword);
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<RecruitDTO> list = recruitService.list(search_option,keyword,start,end);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		mav.setViewName("recruit/list");
		/*mav.setViewName("/");*/
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("view/{idx}")
	public ModelAndView detail(@PathVariable int idx, ModelAndView mav, HttpSession session) {
		recruitService.readCount(idx,session);
		String id=(String)session.getAttribute("id");
		if(id==null) {
			mav.setViewName("recruit/view");
			mav.addObject("dto", recruitService.view(idx));
			return mav;
		}else {
			String result = recruitService.check_recommend(id,idx);
			if(result == null) {
				mav.setViewName("recruit/view");
				mav.addObject("dto", recruitService.view(idx));
				mav.addObject("message2","success");
			}else {
				mav.setViewName("recruit/view");
				mav.addObject("dto", recruitService.view(idx));
				mav.addObject("message2","fail");
			}
			return mav;
		}
	
	}
	
	@RequestMapping("grade_check")
	public ModelAndView grade_check(HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = recruitService.grade_check(id);
		ModelAndView mav = new ModelAndView();
		if(result == 3) {
			mav.setViewName("recruit/write");		
		}else {
			mav.setViewName("redirect:/recruit/list.do");
			mav.addObject("result",result);
		}
		return mav;		
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute RecruitDTO dto, HttpSession session)throws Exception {
		String writer=(String)session.getAttribute("nickName");
		dto.setWriter(writer);
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
           ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		recruitService.create(dto);
		return "redirect:/recruit/list.do";
	}
	
	@RequestMapping("appl_check.do")
	public ModelAndView appl_check(HttpSession session, int idx) {
		String id = (String)session.getAttribute("id");
		String result = recruitService.appl_check(id,idx);
		System.out.println("result="+result);
		ModelAndView mav = new ModelAndView();
		if(result == null) {			
			mav.setViewName("redirect:/recruit/appl.do");
			mav.addObject("idx",idx);
		}else {			
			mav.setViewName("recruit/view");
			mav.addObject("dto", recruitService.view(idx));
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
		recruitService.appl(dto);
		return "redirect:/recruit/view/"+idx;
	}
	
	@RequestMapping("check/{idx}")
	public ModelAndView check_list(@PathVariable int idx) {
		System.out.println("idx="+idx);
		List<MemberDTO> list = recruitService.check_list(idx);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("idx", idx);
		mav.setViewName("recruit/check_list");
		mav.addObject("map", map);
		//System.out.println("num="+num);
		return mav;
	}
	
	@RequestMapping("profile/{writer}")
	public ModelAndView profile(ModelAndView mav,@PathVariable String writer) {
		System.out.println("writer="+writer);
		mav.setViewName("recruit/profile");
		mav.addObject("dto", recruitService.profile(writer));
		return mav;
	}
	
	@RequestMapping("appr.do")
	public String appr(@RequestParam String id, int idx, HttpSession session) {
		System.out.println("id="+id);
		int band = (int)session.getAttribute("band");
		String nickName = (String)session.getAttribute("nickName");
		recruitService.appr(id,idx,band,nickName);
		return "redirect:/recruit/check/"+idx;
	}
	
	@RequestMapping("recommend/{idx}")
	public String recommend(HttpSession session, @PathVariable int idx) {
		RecruitDTO dto = new RecruitDTO();
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		dto.setIdx(idx);
		System.out.println("dto은..."+dto);
		recruitService.recommend(dto);
		return "redirect:/recruit/view/"+idx;
	}
	
	@RequestMapping("band_profile.do")
	public ModelAndView b_profile(ModelAndView mav, String writer) {
		System.out.println("writer.."+writer);
		mav.setViewName("recruit/band_profile");
		mav.addObject("dto", recruitService.band_profile(writer));
		return mav;
	}
	
	@RequestMapping("edit.do")
	public ModelAndView write(ModelAndView mav, int idx) {
		mav.setViewName("recruit/edit");
		mav.addObject("dto", recruitService.view(idx));
		return mav;		
	}
	
	@RequestMapping("update.do")
	public String update(RecruitDTO dto, int idx) {
		dto.setIdx(idx);
		recruitService.update(dto);
		return "redirect:/recruit/view/"+dto.getIdx();
	}
	
	@RequestMapping("delete.do")
	public String delete(int idx) {
		recruitService.delete(idx);
		return "redirect:/recruit/list.do";
	}
	
	@RequestMapping("delete_recommend/{idx}")
	public String delete_recommend(HttpSession session, @PathVariable int idx) {
		String id = (String)session.getAttribute("id");
		recruitService.delete_recommend(id,idx);
		return "redirect:/recruit/view/"+idx;
	}
	
	@RequestMapping("close/{idx}")
	public String close(@PathVariable int idx) {
		recruitService.close(idx);
		return "redirect:/recruit/list.do";
	}

}
