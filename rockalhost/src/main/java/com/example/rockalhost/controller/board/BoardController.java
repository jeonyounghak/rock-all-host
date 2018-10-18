package com.example.rockalhost.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.rockalhost.model.board.dto.BoardCommentDTO;
import com.example.rockalhost.model.board.dto.BoardDTO;
import com.example.rockalhost.service.board.BoardCommentService;
import com.example.rockalhost.service.board.BoardService;
import com.example.rockalhost.util.page.Pager;

@Controller
@RequestMapping("board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@Inject
	BoardCommentService boardCommentService;

	@RequestMapping("list.do")
	public ModelAndView list(
			@RequestParam(defaultValue="searchAll") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		
		int count = boardService.searchCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		List<BoardDTO> items = boardService.list(map);
		mav.setViewName("/board/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("view/{num}")
	public ModelAndView view(@PathVariable int num, ModelAndView mav, HttpSession session) {
		boardService.plusReadcount(num, session);
		
		mav.setViewName("/board/view");
		mav.addObject("dto", boardService.view(num));
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		
		boardService.insert(dto);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("passwdCheck.do")
	public ModelAndView passwdCheck(@ModelAttribute BoardDTO dto) {
		boolean result = boardService.passwdCheck(dto);
		int num = dto.getNum();
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("board/edit");
			mav.addObject("dto", boardService.view(num));
		}else {
			mav.setViewName("board/view");
			mav.addObject("dto", boardService.view(num));
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("hidden.do")
	public String hidden(@ModelAttribute BoardDTO dto) {
        
		boardService.hidden(dto);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("update.do")
	public String update(@ModelAttribute BoardDTO dto) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        
		boardService.update(dto);
		return "redirect:/board/list.do";
	}
	
	// 댓글
	@RequestMapping("commentList.do")
	public ModelAndView commentList(@RequestParam int num, ModelAndView mav) {
		List<BoardCommentDTO> items = boardCommentService.list(num);
		mav.setViewName("/board/commentList");
		mav.addObject("list", items);
		return mav; 
	}
	
	@RequestMapping("commentInsert.do")
	public String commentInsert(@ModelAttribute BoardCommentDTO dto) {
		int board_num = dto.getBoard_num();
		boardCommentService.insert(dto);
		return "redirect:/board/view/"+board_num;
	}
	
	@RequestMapping("commentDelete.do")
	public ModelAndView commentDelete(@ModelAttribute BoardCommentDTO dto) {
		BoardCommentDTO bcDto = new BoardCommentDTO();
		int comment_num = dto.getComment_num();
		bcDto = boardCommentService.view(comment_num);
		
		int board_num = bcDto.getBoard_num();
		
		boolean result = boardCommentService.passwdCheck(dto);
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			boardCommentService.delete(comment_num);
			mav.setViewName("board/view");
			mav.addObject("dto", boardService.view(board_num));
		}else {
			mav.setViewName("board/view");
			mav.addObject("dto", boardService.view(board_num));
			mav.addObject("comment_message", "error");
		}
		return mav;
	}
	
	// 답글
	@RequestMapping("reply.do")
	public ModelAndView reply(@ModelAttribute BoardDTO dto, ModelAndView mav) {
		int num = dto.getNum();
		
		dto = boardService.view(num);
		dto.setContent("\n"+dto.getContent()+
				"\n\n------------------------------------------------ "
				+ "원문 내용 ------------------------------------------------\n");
		mav.setViewName("board/reply");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("insertReply.do")
	public String insertReply(@ModelAttribute BoardDTO dto) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
     
        int num = dto.getNum();
        BoardDTO parentDto = new BoardDTO();
        parentDto = boardService.view(num);
        
        int ref = parentDto.getRef();
        int re_step = parentDto.getRe_step()+1;
        int re_level = parentDto.getRe_level()+1;
        
        dto.setRef(ref);
        dto.setRe_step(re_step);
        dto.setRe_level(re_level);
        
		boardService.reply(dto);
		return "redirect:/board/list.do";
	}
	
}
