package com.example.rockalhost.controller.bandBoard;

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
import com.example.rockalhost.service.qna.QnaService;
import com.example.rockalhost.service.review.ReviewService;
import com.example.rockalhost.util.page.Pager;

@Controller
@RequestMapping("bandBoard/*")
public class BandBoardController {
	@Inject
	PerformanceService performanceService;
	
	@Inject
	ReviewService reviewService;
	
	@Inject
	QnaService qnaService;
	
	//////band review board
	@RequestMapping("rbList.do")
	public ModelAndView rbList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			@RequestParam int b_idx, 
			ModelAndView mav) throws Exception {
		
		Map<String, Object> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("b_idx", b_idx);
		search_map.put("show", "y");
		
		int count = reviewService.getBandRBCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("b_idx", b_idx);
		map.put("show", "y");
		
		List<SubBoardDTO> items = reviewService.rbList(map);
		mav.setViewName("/bandBoard/reviewBoard/list");
		mav.addObject("list", items);
		mav.addObject("b_idx", b_idx);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("rbView.do")
	public ModelAndView rbView(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam String pf_title,
			@RequestParam int num, 
			@RequestParam int b_idx, ModelAndView mav, HttpSession session) {
		
		reviewService.plusReadcount(num, session);
		SubBoardDTO dto = reviewService.view(num);
		
		mav.setViewName("/bandBoard/reviewBoard/view");
		mav.addObject("curPage", curPage);
		mav.addObject("pf_title", pf_title);
		mav.addObject("dto", dto);
		mav.addObject("b_idx", b_idx);
		return mav;
	}
	
	// 댓글
	@RequestMapping("rbCommentList.do")
	public ModelAndView rbCommentList(@RequestParam int b_idx, 
			@RequestParam String pf_title, 
			@RequestParam int num, ModelAndView mav) {
		
		List<SubBoardCommentDTO> items = reviewService.commentList(num);
		mav.setViewName("/bandBoard/reviewBoard/commentList");
		mav.addObject("list", items);
		mav.addObject("pf_title", pf_title);
		mav.addObject("b_idx", b_idx);
		return mav; 
	}
	
	@RequestMapping("rbCommentInsert.do")
	public ModelAndView rbCommentInsert(@RequestParam int b_idx, 
			@ModelAttribute SubBoardCommentDTO dto, 
			@RequestParam String pf_title, ModelAndView mav) {
		
		int num = dto.getBoard_num();
		
		reviewService.commentInsert(dto);
		
		SubBoardDTO bdto = reviewService.view(num);
		
		mav.setViewName("/bandBoard/reviewBoard/view");
		mav.addObject("pf_title", pf_title);
		mav.addObject("dto", bdto);
		mav.addObject("b_idx", b_idx);
		return mav;
	}
	
	@RequestMapping("rbCommentDelete.do")
	public ModelAndView rbCommentDelete(@RequestParam int b_idx, 
			@RequestParam String pf_title, 
			@ModelAttribute SubBoardCommentDTO dto, ModelAndView mav) {
		
		SubBoardCommentDTO dto2 = new SubBoardCommentDTO();
		int comment_num = dto.getComment_num();
		dto2 = reviewService.commentView(comment_num);
		
		int board_num = dto2.getBoard_num();
		boolean result = reviewService.commentPasswdCheck(dto);
		
		if(result) {
			reviewService.commentDelete(comment_num);
			
			mav.setViewName("/bandBoard/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_title", pf_title);
			mav.addObject("b_idx", b_idx);
		}else {
			mav.addObject("comment_message", "error");
			
			mav.setViewName("/bandBoard/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_title", pf_title);
			mav.addObject("b_idx", b_idx);
		}
		return mav;
	}
	
	////// band QnA board
	@RequestMapping("qbList.do")
	public ModelAndView qbList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			@RequestParam int b_idx, ModelAndView mav) throws Exception {
		
		Map<String, Object> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("b_idx", b_idx);
		
		int count = qnaService.getBandQBCount(search_map);
		System.out.println("count : "+count);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("b_idx", b_idx);
		
		List<SubBoardDTO> items = qnaService.qbList(map);
		mav.setViewName("/bandBoard/qnaBoard/list");
		mav.addObject("list", items);
		mav.addObject("b_idx", b_idx);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("qbView.do")
	public ModelAndView qbView(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam int num, 
			@RequestParam String pf_title, 
			@RequestParam int b_idx, ModelAndView mav, HttpSession session) {
		
		qnaService.plusReadcount(num, session);
		SubBoardDTO dto = qnaService.view(num);
		
		mav.setViewName("/bandBoard/qnaBoard/view");
		mav.addObject("dto", dto);
		mav.addObject("pf_title", pf_title);
		mav.addObject("b_idx", b_idx);
		mav.addObject("curPage", curPage);
		return mav;
	}
	
	@RequestMapping("qbInsert.do")
	public ModelAndView qbInsert(@ModelAttribute SubBoardDTO dto, 
			@RequestParam int b_idx, ModelAndView mav) {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		
        qnaService.insert(dto);
        
        mav.addObject("b_idx", b_idx);
        mav.setViewName("redirect:/bandBoard/qbList.do");
		return mav;
	}
	
	@RequestMapping("qbPasswdCheck.do")
	public ModelAndView qbPasswdCheck(@ModelAttribute SubBoardDTO dto) {
		boolean result = qnaService.passwdCheck(dto);
		int num = dto.getNum();
		int b_idx = dto.getB_idx();
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("/bandBoard/qnaBoard/edit");
			mav.addObject("b_idx", b_idx);
			mav.addObject("dto", qnaService.view(num));
		}else {
			mav.setViewName("/bandBoard/qnaBoard/view");
			mav.addObject("dto", qnaService.view(num));
			mav.addObject("b_idx", b_idx);
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("qbUpdate.do")
	public ModelAndView qbUpdate(@ModelAttribute SubBoardDTO dto, @RequestParam int b_idx, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        
        qnaService.update(dto);
        mav.addObject("b_idx", b_idx);
        mav.setViewName("redirect:/bandBoard/qbList.do");
		return mav;
	}
	
	@RequestMapping("qbHidden.do")
	public ModelAndView qbHidden(@ModelAttribute SubBoardDTO dto, @RequestParam int b_idx, ModelAndView mav) {
		qnaService.hidden(dto);
		mav.addObject("b_idx", b_idx);
		mav.setViewName("redirect:/bandBoard/qbList.do");
		return mav;
	}
	
	// 답글
	@RequestMapping("qbReply.do")
	public ModelAndView qbReply(@RequestParam int b_idx, @ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		int num = dto.getNum();
			
		dto = qnaService.view(num);
		dto.setContent("\n"+dto.getContent()+
				"<p>------------------------------------------- "
				+ "원문 내용 -------------------------------------------<p>");
		
		mav.setViewName("/bandBoard/qnaBoard/reply");
		mav.addObject("b_idx", b_idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("qbInsertReply.do")
	public ModelAndView qbInsertReply(@ModelAttribute SubBoardDTO dto, @RequestParam int b_idx, ModelAndView mav) {
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
        mav.addObject("b_idx", b_idx);
        mav.setViewName("redirect:/bandBoard/qbList.do");
		return mav;
	}
	
}
