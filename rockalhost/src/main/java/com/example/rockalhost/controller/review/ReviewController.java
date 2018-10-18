package com.example.rockalhost.controller.review;
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
import com.example.rockalhost.model.subBoardComment.dto.SubBoardCommentDTO;
import com.example.rockalhost.service.performance.PerformanceService;
import com.example.rockalhost.service.review.ReviewService;
import com.example.rockalhost.util.page.Pager;

@Controller
@RequestMapping("review/*")
public class ReviewController {
	
	@Inject
	PerformanceService performanceService;
	
	@Inject
	ReviewService reviewService;
	
	@RequestMapping("tabList.do")
	public ModelAndView tabList(@RequestParam(defaultValue="1") int curPage, @RequestParam(defaultValue="0") int num, 
			@RequestParam int pf_idx, ModelAndView mav) throws Exception {
		
		int count = reviewService.getCount(pf_idx);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Integer> map = new HashMap<>(pf_idx);
		map.put("start", start);
		map.put("end", end);
		map.put("pf_idx", pf_idx);
		
		List<SubBoardDTO> items = reviewService.list(map);
		mav.setViewName("/reviewBoard/tabList");
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
		
		int count = reviewService.getCount(pf_idx);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("pf_idx", pf_idx);
		
		List<SubBoardDTO> items = reviewService.list(map);
		mav.setViewName("/reviewBoard/list");
		mav.addObject("list", items);
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		
		return mav; 
	}
	
	@RequestMapping("view.do")
	public ModelAndView view(@RequestParam(defaultValue="1") int curPage, @RequestParam int num, 
			@RequestParam int pf_idx, ModelAndView mav, HttpSession session) {
		
		reviewService.plusReadcount(num, session);
		SubBoardDTO dto = reviewService.view(num);
		
		mav.setViewName("/reviewBoard/view");
		mav.addObject("dto", dto);
		mav.addObject("pf_idx", pf_idx);
		mav.addObject("curPage", curPage);
		return mav;
	}
	
	@RequestMapping("write.do")
	public ModelAndView write(@RequestParam int pf_idx, ModelAndView mav) {	
		mav.setViewName("/reviewBoard/write");
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
		
        reviewService.insert(dto);
        
        mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	@RequestMapping("passwdCheck.do")
	public ModelAndView passwdCheck(@ModelAttribute SubBoardDTO dto) {
		boolean result = reviewService.passwdCheck(dto);
		int num = dto.getNum();
		int pf_idx = dto.getPf_idx();
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("reviewBoard/edit");
			mav.addObject("pf_idx", pf_idx);
			mav.addObject("dto", reviewService.view(num));
		}else {
			mav.setViewName("/reviewBoard/view");
			mav.addObject("dto", reviewService.view(num));
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
        
        reviewService.update(dto);
        mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	@RequestMapping("hidden.do")
	public ModelAndView hidden(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
        
		reviewService.hidden(dto);
		mav.setViewName("redirect:/performance/view/"+dto.getPf_idx());
		return mav;
	}
	
	
	// 댓글
	@RequestMapping("commentList.do")
	public ModelAndView commentList(@RequestParam int pf_idx, @RequestParam int num, ModelAndView mav) {
		List<SubBoardCommentDTO> items = reviewService.commentList(num);
		mav.setViewName("/reviewBoard/commentList");
		mav.addObject("list", items);
		mav.addObject("pf_idx", pf_idx);
		return mav; 
	}
	
	@RequestMapping("commentInsert.do")
	public ModelAndView commentInsert(@RequestParam int pf_idx, @ModelAttribute SubBoardCommentDTO dto, ModelAndView mav) {
		int num = dto.getBoard_num();
		
		reviewService.commentInsert(dto);
		
		SubBoardDTO bdto = reviewService.view(num);
		
		mav.setViewName("/reviewBoard/view");
		mav.addObject("dto", bdto);
		mav.addObject("pf_idx", pf_idx);
		return mav;
	}
	
	@RequestMapping("commentDelete.do")
	public ModelAndView commentDelete(@RequestParam int pf_idx, @ModelAttribute SubBoardCommentDTO dto, ModelAndView mav) {
		SubBoardCommentDTO dto2 = new SubBoardCommentDTO();
		int comment_num = dto.getComment_num();
		dto2 = reviewService.commentView(comment_num);
		
		int board_num = dto2.getBoard_num();
		boolean result = reviewService.commentPasswdCheck(dto);
		
		if(result) {
			reviewService.commentDelete(comment_num);
			
			mav.setViewName("/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_idx", pf_idx);
		}else {
			mav.addObject("comment_message", "error");
			
			mav.setViewName("/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_idx", pf_idx);
		}
		return mav;
	}
	
	
}