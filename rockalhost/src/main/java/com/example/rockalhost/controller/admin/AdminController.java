package com.example.rockalhost.controller.admin;

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

import com.example.rockalhost.model.admin.dto.AdminDTO;
import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.band.dto.AllbandViewDTO;
import com.example.rockalhost.model.band.dto.MybandDTO;
import com.example.rockalhost.model.board.dto.BoardCommentDTO;
import com.example.rockalhost.model.board.dto.BoardDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.model.performance.dto.PerformanceViewDTO;
import com.example.rockalhost.model.recruit.dto.RecruitDTO;
import com.example.rockalhost.model.seek.dto.SeekDTO;
import com.example.rockalhost.model.subBoard.dto.SubBoardDTO;
import com.example.rockalhost.model.subBoardComment.dto.SubBoardCommentDTO;
import com.example.rockalhost.service.admin.AdminService;
import com.example.rockalhost.service.band.AllbandService;
import com.example.rockalhost.service.band.MybandService;
import com.example.rockalhost.service.board.BoardCommentService;
import com.example.rockalhost.service.board.BoardService;
import com.example.rockalhost.service.member.MemberService;
import com.example.rockalhost.service.performance.PerformanceService;
import com.example.rockalhost.service.qna.QnaService;
import com.example.rockalhost.service.recruit.RecruitService;
import com.example.rockalhost.service.review.ReviewService;
import com.example.rockalhost.service.seek.SeekService;
import com.example.rockalhost.util.page.Pager;

@Controller
@RequestMapping("admin/*")
public class AdminController {
	
	@Inject
	AdminService adminService;
	@Inject
	PerformanceService performanceService;
	@Inject
	MemberService memberService;
	@Inject
	AllbandService allbandService;
	@Inject
	MybandService MybandService;
	@Inject
	RecruitService recruitService;
	@Inject
	SeekService seekService;
	@Inject
	ReviewService reviewService;
	@Inject
	QnaService qnaService;
	@Inject
	BoardService boardService;
	@Inject
	BoardCommentService boardCommentService;
	
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView loginCheck(AdminDTO dto, HttpSession session) {
		boolean result = adminService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("redirect:/admin/management/main.do");
		}else {
			mav.setViewName("admin/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout (HttpSession session, ModelAndView mav) {
		adminService.logout(session);
		mav.setViewName("admin/login");
		mav.addObject("message", "logout");
		return mav;	
	}
	
	@RequestMapping("management/main.do")
	public String goMain() {
		return "admin/main";
	}
	
	
	
	/////// performance admin
	@RequestMapping("performance/list.do")
	public ModelAndView performanceList(
			@RequestParam(defaultValue="searchAll") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		
		int count = performanceService.searchCount(search_map);
		System.out.println("게시물 갯수 : "+count);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		List<PerformanceViewDTO> items = performanceService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/performance/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav;
	}
	
	@RequestMapping("performance/delList.do")
	public ModelAndView performanceDelList(
			@RequestParam(defaultValue="searchAll") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		
		int count = performanceService.searchCount(search_map);

		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		List<PerformanceViewDTO> items = performanceService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/performance/delList");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav;
	}
	
	@RequestMapping("performance/delete.do")
	public String performanceListDelete(@RequestParam int pf_idx) throws Exception {
		performanceService.hide(pf_idx);
		
		return "redirect:/admin/performance/list.do";
	}
	
	@RequestMapping("performance/eternalDel.do")
	public String performanceEternalDel(@RequestParam int pf_idx) throws Exception {
		
		performanceService.delete(pf_idx);
		
		return "admin/performance/DelList";
	}
	
	@RequestMapping("performance/view/{pf_idx}")
	public ModelAndView performanceView(@PathVariable int pf_idx, ModelAndView mav, HttpSession session) {
		
		mav.setViewName("admin/performance/view");
		mav.addObject("dto", performanceService.view(pf_idx));
		return mav;
	}
	
	
	
	/////// chart admin
	@RequestMapping("chart/{chart_type}")
	public String chart(@PathVariable String chart_type) {
		
		return "chart/"+chart_type;
	}
	
	
	/////// member admin
	@RequestMapping("withdrawalList.do")
	public ModelAndView withdrawalList(ModelAndView mav,@RequestParam(defaultValue="1") int curPage) {
		 System.out.println("withdrawalList.do 호출");
		 int withdrawalCount = memberService.withdrawalCount();
		 
		 Pager pager = new Pager(withdrawalCount, curPage);
	     int start = pager.getPageBegin();
	     int end = pager.getPageEnd();
			
	     Map<String, Object> map = new HashMap<>();
		 map.put("start", start);
	     map.put("end", end);
		 
		 List<MemberDTO> list = memberService.withdrawalList(map);
		 
		 mav.setViewName("admin/member/withdrawalList");
		 mav.addObject("list",list);
		 mav.addObject("withdrawalCount", withdrawalCount);
		 mav.addObject("page", pager);
		 return mav;
		}
	
	@RequestMapping("withdrawal.do")
	public ModelAndView withdrawal(MemberDTO dto, ModelAndView mav, String id) {
		System.out.println("withdrawal.do 호출");
		memberService.withdrawal(id);
		mav.addObject("message", "withdrawal");
		mav.setViewName("redirect:/admin/memberList.do");
		return mav;
	}
	
	@RequestMapping("memberListView/{id}")
	public ModelAndView listView(@PathVariable String id, ModelAndView mav) {
		System.out.println("listView/{id} 호출");
		mav.addObject("dto", memberService.viewMember(id));
		mav.setViewName("admin/member/edit");
		return mav;
	}
	@RequestMapping("withdrawalListView/{id}")
	public ModelAndView withdrawalListView(@PathVariable String id, ModelAndView mav) {
		System.out.println("listView/{id} 호출");
		mav.addObject("dto", memberService.viewMember(id));
		mav.setViewName("admin/member/withdrawal_edit");
		return mav;
	}
	
	@RequestMapping("adminUpdate.do")
    public ModelAndView adminMemberUpdate(MemberDTO dto, ModelAndView mav) {
		System.out.println("adminUpdate.do 호출");
		memberService.adminUpdateMember(dto);
		System.out.println("adminUpdate.do memberService"+dto);
		mav.setViewName("redirect:/admin/memberList.do");
		mav.addObject("message","update");
		return mav;
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(String id, String passwd, ModelAndView mav) {
		System.out.println("delete.do 호출");
			memberService.delete(id);
			mav.addObject("message", "delete");
			mav.setViewName("redirect:/admin/withdrawalList.do");
			return mav;
	
		}
	@RequestMapping("onclickWithdrawal/{id}")
	public ModelAndView onclickWithdrawal (@PathVariable String id, ModelAndView mav) {
		System.out.println("memberwithdrawal/{id} 호출" + id);
		memberService.withdrawal(id);
		mav.addObject("message", "withdrawal");
		mav.setViewName("redirect:/admin/memberList.do");
		return mav;
	   }
	
	@RequestMapping("onclickRestore/{id}")
	public ModelAndView onclickRestore (@PathVariable String id, ModelAndView mav) {
		MemberDTO dto = memberService.viewMember(id);
		System.out.println("onclickRestore/{id} 호출");
		System.out.println("onclickRestore/{id} 호출:"+id);
		memberService.onclickRestore(dto);
		mav.setViewName("redirect:/admin/withdrawalList.do");
		return mav;
	}
	
	@RequestMapping("memberList.do")
	public ModelAndView memberList(ModelAndView mav, @RequestParam(defaultValue="1") int curPage) {
		System.out.println("admin list.do 호출");
		int memberCount = memberService.memberCount();
		
		Pager pager = new Pager(memberCount, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<MemberDTO> list = memberService.list(map);
		mav.setViewName("admin/member/list");
		mav.addObject("list",list);
		mav.addObject("memberCount",memberCount);
		mav.addObject("page", pager);
		return mav;
	}
	
	@RequestMapping("memberSearch.do")
	public ModelAndView search(ModelAndView mav, HttpServletRequest request) {
		System.out.println("memberSearch.do 호출");
		int memberCount = memberService.memberCount();
		String search_option = request.getParameter("search_option");
		String keyword = request.getParameter("keyword");
		System.out.println("memberSearch.do search_option:"+search_option);
		System.out.println("memberSearch.do keyword:"+keyword);
		List<MemberDTO> list = memberService.list(search_option,keyword);
		mav.addObject("memberCount",memberCount);
		mav.setViewName("admin/member/list");
		mav.addObject("list",list);
		
		return mav;
	}
	
	@RequestMapping("withdrawalSearch.do")
	public ModelAndView withdrawalSearch(ModelAndView mav, HttpServletRequest request) {
		System.out.println("withdrawalSearch.do 호출");
		int withdrawalCount = memberService.withdrawalCount();
		String search_option = request.getParameter("search_option");
		String keyword = request.getParameter("keyword");
		System.out.println("withdrawalSearch.do search_option:"+search_option);
		System.out.println("withdrawalSearch.do keyword:"+keyword);
		List<MemberDTO> list = memberService.withdrawalList(search_option,keyword);
		mav.addObject("withdrawalCount",withdrawalCount);
		mav.setViewName("admin/member/withdrawalList");
		mav.addObject("list",list);
		
		return mav;
	}
	
	
	
	
	/////// band admin
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue="1") int curPage) throws Exception {
		int bandCount = allbandService.bandCount();
		
		Pager pager = new Pager(bandCount, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);		
		
		List<AllbandViewDTO> list = allbandService.list(map);	
		System.out.println("list = "+list);
		mav.setViewName("admin/band/band");
		mav.addObject("list", list); 
		mav.addObject("bandCount", bandCount);
		mav.addObject("page", pager); 
		return mav; 
	}//list()	
	
	@RequestMapping("bandSearch.do")
	public ModelAndView bandsearch(ModelAndView mav, HttpServletRequest request) {
		System.out.println("bandSearch.do 호출");
		int bandCount = allbandService.bandCount();
		String search_option = request.getParameter("search_option");
		String keyword = request.getParameter("keyword");
		System.out.println("bandSearch.do search_option:"+search_option);
		System.out.println("bandSearch.do keyword:"+keyword);
		List<AllbandViewDTO> list = allbandService.bandlist(search_option,keyword);
		mav.addObject("bandCount",bandCount);
		mav.setViewName("admin/band/band");
		mav.addObject("list",list);
		
		return mav;
	}


	
	@RequestMapping("adminband/{b_idx}")
	public ModelAndView adminlist(@PathVariable int b_idx) throws Exception {
		System.out.println("adminlist.do 호출중...");
		System.out.println("idx="+b_idx);
		List<MybandDTO> list = MybandService.leaderlist(b_idx);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("admin/band/adminband");
		mav.addObject("map", map); 
		return mav; 				
	}
	
	@RequestMapping("adminBandDelete.do")
	public ModelAndView adminBandDelete(MemberDTO dto, ModelAndView mav) {
		System.out.println("adminBandDelete.do 호출중..");				
		MybandService.adminBandDelete(dto);	
		System.out.println(dto);
		mav.setViewName("redirect:/admin/list.do");
		return mav;		
	}
	
	@RequestMapping("applylist.do")
	public ModelAndView applylist() throws Exception {
		List<AllbandViewDTO> list = allbandService.applylist();
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("admin/band/applylist");
		mav.addObject("map", map); 
		return mav; 
	}//list()
	
	@RequestMapping("applyshow/{nickName}")
	public ModelAndView applyview(@PathVariable String nickName, ModelAndView mav) {
		System.out.println("temperProfile.do 호출중..");				
		AllbandViewDTO dto = allbandService.applyshow(nickName);	
		System.out.println("nickname="+nickName);
		mav.addObject("dto", dto);		
		mav.setViewName("admin/band/applyshow");
		return mav;		
	}
	
	@RequestMapping("adminapply.do")
	public ModelAndView adminapply(AllbandDTO dto, ModelAndView mav) throws Exception {
		System.out.println("adminapply.do 호출중..");				
		allbandService.adminapply(dto);	
		System.out.println("dto="+dto);	
		mav.addObject("dto", dto);
		mav.setViewName("redirect:/admin/applylist.do");
		return mav;		
	}
	
	@RequestMapping("memberview/{nickName}")
	public ModelAndView memberview(@PathVariable String nickName, ModelAndView mav) {
		System.out.println("listView/{nickName} 호출");
		mav.addObject("dto", allbandService.memberview(nickName));
		mav.setViewName("admin/member/edit");
		return mav;
	}
	
	
	
	/////// recruit admin
	@RequestMapping("recruit_list.do")
	public ModelAndView recruit_list(
			@RequestParam(defaultValue="writer") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		System.out.println("keyword="+keyword);
		int count = recruitService.countArticle(search_option,keyword);
		com.example.rockalhost.service.recruit.Pager pager=new com.example.rockalhost.service.recruit.Pager(count, curPage);
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
		mav.setViewName("admin/recruit/recruit_list");
		/*mav.setViewName("/");*/
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("recruit_view/{idx}")
	public ModelAndView recruit_view(@PathVariable int idx, ModelAndView mav, HttpSession session) {
		recruitService.readCount(idx,session);
		String id=(String)session.getAttribute("id");
		mav.setViewName("admin/recruit/recruit_view");
		if(id==null) {
			mav.addObject("dto", recruitService.view(idx));
			return mav;
		}else {
			String result = recruitService.check_recommend(id,idx);
			if(result == null) {
				mav.addObject("dto", recruitService.view(idx));
				mav.addObject("message2","success");
			}else {
				mav.addObject("dto", recruitService.view(idx));
				mav.addObject("message2","fail");
			}
			return mav;
		}	
	}
	
	@RequestMapping("recruit_delete.do")
	public String delete(int idx) {
		recruitService.delete(idx);
		return "redirect:/admin/recruit_list.do";
	}
	
	@RequestMapping("seek_list.do")
	public ModelAndView seek_list(
			@RequestParam(defaultValue="writer") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		System.out.println("keyword="+keyword);
		int count = seekService.countArticle(search_option,keyword);
		com.example.rockalhost.service.recruit.Pager pager=new com.example.rockalhost.service.recruit.Pager(count, curPage);
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
		mav.setViewName("admin/seek/seek_list");
		/*mav.setViewName("/");*/
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("seek_view/{idx}")
	public ModelAndView seek_view(@PathVariable int idx, ModelAndView mav, HttpSession session) {
		recruitService.readCount(idx,session);
		String id=(String)session.getAttribute("id");
		mav.setViewName("admin/seek/seek_view");
		if(id==null) {
			mav.addObject("dto", seekService.view(idx));
			return mav;
		}else {
			String result = seekService.check_recommend(id,idx);
			if(result == null) {
				mav.addObject("dto", seekService.view(idx));
				mav.addObject("message2","success");
			}else {
				mav.addObject("dto", seekService.view(idx));
				mav.addObject("message2","fail");
			}
			return mav;
		}	
	}
	
	@RequestMapping("seek_delete.do")
	public String seek_delete(int idx) {
		seekService.delete(idx);
		return "redirect:/admin/seek_list.do";
	}
	
	
	
	/////// review admin
	@RequestMapping("rbList.do")
	public ModelAndView rbList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			ModelAndView mav) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "y");
		
		int count = reviewService.getAdminCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("show", "y");
		
		List<SubBoardDTO> items = reviewService.adminList(map);
		mav.setViewName("/admin/reviewBoard/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("rbView.do")
	public ModelAndView rbView(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam String pf_title,
			@RequestParam int num, 
			ModelAndView mav, HttpSession session) {
		
		reviewService.plusReadcount(num, session);
		SubBoardDTO dto = reviewService.view(num);
		
		mav.setViewName("/admin/reviewBoard/view");
		mav.addObject("curPage", curPage);
		mav.addObject("pf_title", pf_title);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("rbHidden.do")
	public ModelAndView hidden(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
        
		reviewService.hidden(dto);
		mav.setViewName("redirect:/admin/rbList.do");
		return mav;
	}
	
	@RequestMapping("rbDelList.do")
	public ModelAndView rbDelList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			ModelAndView mav) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "n");
		
		int count = reviewService.getAdminCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("show", "n");
		
		List<SubBoardDTO> items = reviewService.adminList(map);
		mav.setViewName("/admin/reviewBoard/delList");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	// 댓글
	@RequestMapping("rbCommentList.do")
	public ModelAndView rbCommentList(@RequestParam String pf_title, 
			@RequestParam int num, ModelAndView mav) {
		
		List<SubBoardCommentDTO> items = reviewService.commentList(num);
		mav.setViewName("/admin/reviewBoard/commentList");
		mav.addObject("list", items);
		mav.addObject("pf_title", pf_title);
		return mav; 
	}
	
	@RequestMapping("rbCommentInsert.do")
	public ModelAndView rbCommentInsert(@ModelAttribute SubBoardCommentDTO dto, 
			@RequestParam String pf_title, ModelAndView mav) {
		
		int num = dto.getBoard_num();
		
		reviewService.commentInsert(dto);
		
		SubBoardDTO bdto = reviewService.view(num);
		
		mav.setViewName("/admin/reviewBoard/view");
		mav.addObject("pf_title", pf_title);
		mav.addObject("dto", bdto);
		return mav;
	}
	
	@RequestMapping("rbCommentDelete.do")
	public ModelAndView rbCommentDelete(@RequestParam String pf_title, 
			@ModelAttribute SubBoardCommentDTO dto, ModelAndView mav) {
		
		SubBoardCommentDTO dto2 = new SubBoardCommentDTO();
		int comment_num = dto.getComment_num();
		dto2 = reviewService.commentView(comment_num);
		
		int board_num = dto2.getBoard_num();
		boolean result = reviewService.commentPasswdCheck(dto);
		
		if(result) {
			reviewService.commentDelete(comment_num);
			
			mav.setViewName("/admin/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_title", pf_title);
		}else {
			mav.addObject("comment_message", "error");
			
			mav.setViewName("/admin/reviewBoard/view");
			mav.addObject("dto", reviewService.view(board_num));
			mav.addObject("pf_title", pf_title);
		}
		return mav;
	}
	
	////// QnA admin
	@RequestMapping("qbList.do")
	public ModelAndView qbList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			ModelAndView mav) throws Exception {
		
		Map<String, Object> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "y");
		
		int count = qnaService.getAdminQBCount(search_map);
		System.out.println("count : "+count);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("show", "y");
		
		List<SubBoardDTO> items = qnaService.adminQBList(map);
		mav.setViewName("/admin/qnaBoard/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("qbDelList.do")
	public ModelAndView qbDelList(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="searchAll") String search_option, 
			@RequestParam(defaultValue="") String keyword, 
			ModelAndView mav) throws Exception {
		
		Map<String, Object> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "n");
		
		int count = qnaService.getAdminQBCount(search_map);
		System.out.println("count : "+count);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("show", "n");
		
		List<SubBoardDTO> items = qnaService.adminQBList(map);
		mav.setViewName("/admin/qnaBoard/delList");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("qbView.do")
	public ModelAndView qbView(@RequestParam(defaultValue="1") int curPage, 
			@RequestParam int num, 
			@RequestParam String pf_title, 
			ModelAndView mav, HttpSession session) {
		
		qnaService.plusReadcount(num, session);
		SubBoardDTO dto = qnaService.view(num);
		
		mav.setViewName("/admin/qnaBoard/view");
		mav.addObject("dto", dto);
		mav.addObject("pf_title", pf_title);
		mav.addObject("curPage", curPage);
		return mav;
	}
	
	@RequestMapping("qbInsert.do")
	public ModelAndView qbInsert(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		
        qnaService.insert(dto);
        
        mav.setViewName("redirect:/admin/qbList.do");
		return mav;
	}
	
	@RequestMapping("qbPasswdCheck.do")
	public ModelAndView qbPasswdCheck(@ModelAttribute SubBoardDTO dto, @RequestParam String pf_title) {
		boolean result = qnaService.passwdCheck(dto);
		int num = dto.getNum();
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("/admin/qnaBoard/edit");
			mav.addObject("pf_title", pf_title);
			mav.addObject("dto", qnaService.view(num));
		}else {
			mav.setViewName("/admin/qnaBoard/view");
			mav.addObject("dto", qnaService.view(num));
			mav.addObject("pf_title", pf_title);
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("qbUpdate.do")
	public ModelAndView qbUpdate(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        
        qnaService.update(dto);
        mav.setViewName("redirect:/admin/qbList.do");
		return mav;
	}
	
	@RequestMapping("qbHidden.do")
	public ModelAndView qbHidden(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		qnaService.hidden(dto);
		mav.setViewName("redirect:/admin/qbList.do");
		return mav;
	}
	
	// 답글
	@RequestMapping("qbReply.do")
	public ModelAndView qbReply(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		int num = dto.getNum();
		
		SubBoardDTO dto2 = new SubBoardDTO();
		
		dto2 = qnaService.view(num);
		dto2.setContent("\n"+dto2.getContent()+
				"<p>------------------------------------------- "
				+ "원문 내용 -------------------------------------------<p>");
		
		System.out.println("dto2 : "+dto2);
		mav.setViewName("/admin/qnaBoard/reply");
		mav.addObject("dto", dto2);
		return mav;
	}
	
	@RequestMapping("qbInsertReply.do")
	public ModelAndView qbInsertReply(@ModelAttribute SubBoardDTO dto, ModelAndView mav) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
     
        int num = dto.getNum();
        SubBoardDTO dto2 = new SubBoardDTO();
        dto2 = qnaService.view(num);
        
        int ref = dto2.getRef();
        int re_step = dto2.getRe_step()+1;
        int re_level = dto2.getRe_level()+1;
        
        dto.setRef(ref);
        dto.setRe_step(re_step);
        dto.setRe_level(re_level);
        
        qnaService.reply(dto);
        mav.setViewName("redirect:/admin/qbList.do");
		return mav;
	}
	
	
	
	////// board admin
	@RequestMapping("boardList.do")
	public ModelAndView boardList(
			@RequestParam(defaultValue="searchAll") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "y");
		
		int count = boardService.adminCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("show", "y");
		
		List<BoardDTO> items = boardService.adminList(map);
		mav.setViewName("admin/board/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("boardDelList.do")
	public ModelAndView boardDelList(
			@RequestParam(defaultValue="searchAll") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		Map<String, String> search_map = new HashMap<>();
		search_map.put("search_option", search_option);
		search_map.put("keyword", keyword);
		search_map.put("show", "n");
		
		int count = boardService.adminCount(search_map);
		
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("show", "n");
		
		List<BoardDTO> items = boardService.adminList(map);
		mav.setViewName("admin/board/delList");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav; 
	}
	
	@RequestMapping("boardView/{num}")
	public ModelAndView boardView(@PathVariable int num, ModelAndView mav, HttpSession session) {
		boardService.plusReadcount(num, session);
		
		mav.setViewName("admin/board/view");
		mav.addObject("dto", boardService.view(num));
		return mav;
	}
	
	@RequestMapping("boardWrite.do")
	public String boardWrite() {
		return "admin/board/write";
	}
	
	@RequestMapping("boardInsert.do")
	public String boardInsert(@ModelAttribute BoardDTO dto) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
		
		boardService.insert(dto);
		return "redirect:/admin/boardList.do";
	}
	
	@RequestMapping("boardPasswdCheck.do")
	public ModelAndView boardPasswdCheck(@ModelAttribute BoardDTO dto) {
		boolean result = boardService.passwdCheck(dto);
		int num = dto.getNum();
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("admin/board/edit");
			mav.addObject("dto", boardService.view(num));
		}else {
			mav.setViewName("admin/board/view");
			mav.addObject("dto", boardService.view(num));
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("boardHidden.do")
	public String boardHidden(@ModelAttribute BoardDTO dto) {
        
		boardService.hidden(dto);
		return "redirect:/admin/boardList.do";
	}
	
	@RequestMapping("boardUpdate.do")
	public String boardUpdate(@ModelAttribute BoardDTO dto) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) {
        	ip = req.getRemoteAddr();
        }
        dto.setIp(ip);
        
		boardService.update(dto);
		return "redirect:/admin/boardList.do";
	}
	
	// 댓글
	@RequestMapping("boardCommentList.do")
	public ModelAndView boardCommentList(@RequestParam int num, ModelAndView mav) {
		List<BoardCommentDTO> items = boardCommentService.list(num);
		mav.setViewName("/admin/board/commentList");
		mav.addObject("list", items);
		return mav; 
	}
	
	@RequestMapping("boardCommentInsert.do")
	public String boardCommentInsert(@ModelAttribute BoardCommentDTO dto) {
		int board_num = dto.getBoard_num();
		boardCommentService.insert(dto);
		return "redirect:/admin/boardView/"+board_num;
	}
	
	@RequestMapping("boardCommentDelete.do")
	public ModelAndView boardCommentDelete(@ModelAttribute BoardCommentDTO dto) {
		BoardCommentDTO bcDto = new BoardCommentDTO();
		int comment_num = dto.getComment_num();
		bcDto = boardCommentService.view(comment_num);
		
		int board_num = bcDto.getBoard_num();
		
		boolean result = boardCommentService.passwdCheck(dto);
		
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			boardCommentService.delete(comment_num);
			mav.setViewName("admin/board/view");
			mav.addObject("dto", boardService.view(board_num));
		}else {
			mav.setViewName("admin/board/view");
			mav.addObject("dto", boardService.view(board_num));
			mav.addObject("comment_message", "error");
		}
		return mav;
	}
	
	// 답글
	@RequestMapping("boardReply.do")
	public ModelAndView boardReply(@ModelAttribute BoardDTO dto, ModelAndView mav) {
		int num = dto.getNum();
		
		dto = boardService.view(num);
		dto.setContent("\n"+dto.getContent()+
				"\n\n------------------------------------------------ "
				+ "원문 내용 ------------------------------------------------\n");
		mav.setViewName("admin/board/reply");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("boardInsertReply.do")
	public String boardInsertReply(@ModelAttribute BoardDTO dto) {
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
		return "redirect:/admin/boardList.do";
	}
	
	
}
