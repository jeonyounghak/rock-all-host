package com.example.rockalhost.controller.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;
import com.example.rockalhost.service.performance.PerformanceService;
import com.example.rockalhost.service.qna.QnaService;
import com.example.rockalhost.util.page.Pager;

@Controller
@RequestMapping("qna/*")
public class QnaController {
	
	@Inject
	PerformanceService performanceService;
	
	@Inject
	QnaService qnaService;
	
	@RequestMapping("tabList.do")
	public ModelAndView tabList(@RequestParam(defaultValue="1") int curPage, @RequestParam(defaultValue="0") int num, 
			@RequestParam int pf_idx, ModelAndView mav) throws Exception {
		
		int count = qnaService.getCount(pf_idx);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("pf_idx", pf_idx);
		
		List<SubBoardDTO> items = qnaService.list(map);
		mav.setViewName("/qnaBoard/tabList");
		mav.addObject("list", items);
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("curBoard_num", num);
		
		return mav; 
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="1") int curPage, @RequestParam int pf_idx, ModelAndView mav) 
			throws Exception {
		
		int count = qnaService.getCount(pf_idx);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("pf_idx", pf_idx);
		
		List<SubBoardDTO> items = qnaService.list(map);
		mav.setViewName("/qnaBoard/list");
		mav.addObject("list", items);
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		return mav; 
	}
	
	@RequestMapping("view.do")
	public ModelAndView view(@RequestParam(defaultValue="1") int curPage, @RequestParam int num, 
			@RequestParam int pf_idx, ModelAndView mav, HttpSession session) {
		
		qnaService.plusReadcount(num, session);
		SubBoardDTO dto = qnaService.view(num);
		
		mav.setViewName("/qnaBoard/view");
		mav.addObject("dto", dto);
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("curPage", curPage);
		return mav;
	}
	
	@RequestMapping("write.do")
	public ModelAndView write(@RequestParam int pf_idx, ModelAndView mav) {	
		mav.setViewName("/qnaBoard/write");
		mav.addObject("pf_idx", pf_idx);
		return mav;
	}
	
	@RequestMapping("insert.do")
	public ModelAndView insert(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		
        qnaService.insert(dto);
        
        mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	@RequestMapping("passwdCheck.do")
	public ModelAndView passwdCheck(@ModelAttribute SubBoardDTO dto) {
		boolean result = qnaService.passwdCheck(dto);
		int num = dto.getNum();
		int pf_idx = dto.getPf_idx();
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("qnaBoard/edit");
			mav.addObject("pf_idx", pf_idx);
			mav.addObject("dto", qnaService.view(num));
		}else {
			mav.setViewName("/qnaBoard/view");
			mav.addObject("dto", qnaService.view(num));
			mav.addObject("pf_idx", pf_idx);
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        
        qnaService.update(dto);
        mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	@RequestMapping("hidden.do")
	public ModelAndView hidden(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		qnaService.hidden(dto);
		mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	
	// 답글
	@RequestMapping("reply.do")
	public ModelAndView reply(@RequestParam int pf_idx, @ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		int num = dto.getNum();
			
		dto = qnaService.view(num);
		dto.setContent("\n"+dto.getContent()+
				"\n\n------------------------------------------- "
				+ "원문 내용 -------------------------------------------\n");
		
		mav.setViewName("/qnaBoard/reply");
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("insertReply.do")
	public ModelAndView insertReply(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
     
        int num = dto.getNum();
        SubBoardDTO parentDto = new SubBoardDTO();
        parentDto = qnaService.view(num);
        
        int ref = parentDto.getRef();
        int re_step = parentDto.getRe_step()+1;
        int re_level = parentDto.getRe_level()+1;
        
        dto.setRef(ref);
        dto.setRe_step(re_step);
        dto.setRe_level(re_level);
        
        qnaService.reply(dto);
        mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
}