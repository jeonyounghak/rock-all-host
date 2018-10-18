package com.example.rockalhost.controller.performance;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.performance.dto.PerformanceDTO;
import com.example.rockalhost.model.performance.dto.PerformanceViewDTO;
import com.example.rockalhost.service.performance.PerformanceService;
import com.example.rockalhost.util.page.Pager;


@Controller
@RequestMapping("performance/*")
public class PerformanceController {
	
	@Inject
	PerformanceService performanceService;
	
	@RequestMapping("list.do")
	public ModelAndView list(
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
		mav.setViewName("/performance/list");
		mav.addObject("list", items);
		mav.addObject("page", pager);
		mav.addObject("count", count);
		mav.addObject("search_map", search_map);
		
		return mav;
	}
	
	@RequestMapping("view/{pf_idx}")
	public ModelAndView view(@PathVariable int pf_idx, ModelAndView mav, HttpSession session) {
		performanceService.plusReadcount(pf_idx, session);
		
		mav.setViewName("/performance/view");
		mav.addObject("dto", performanceService.view(pf_idx));
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "performance/write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute PerformanceDTO dto) {
		String filename="-";
		
		if(!dto.getImgFile().isEmpty()) {
			filename = dto.getImgFile().getOriginalFilename();
			try {
				//개발 디렉토리
				String path="D:\\work\\rockalhost\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				//String path="C:\\Users\\senor\\Documents\\work_spring\\rockalhost\\src\\main\\webapp\\WEB-INF\\views\\images\\";

				//배포디렉토리 - 서버 clean 
				//String path="D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images";
				
				new File(path).mkdir();
		
				dto.getImgFile().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPf_img(filename);
        performanceService.insert(dto);
		return "redirect:/performance/list.do";
	}
	
	@RequestMapping("edit.do")
	public ModelAndView view(@RequestParam int pf_idx, ModelAndView mav) {
		mav.setViewName("/performance/edit");
		mav.addObject("dto", performanceService.view(pf_idx));
		return mav;
	}
	
	@RequestMapping("update.do")
	public String update(@ModelAttribute PerformanceDTO dto) {
		String filename="-";
		
		if(!dto.getImgFile().isEmpty()) {
			filename = dto.getImgFile().getOriginalFilename();
			try {
				//개발 디렉토리
				String path="D:\\work\\rockalhost\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				//String path="C:\\Users\\senor\\Documents\\work_spring\\rockalhost\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				
				//배포디렉토리 - 서버 clean 
				//String path="D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images";
				
				new File(path).mkdir();
		
				dto.getImgFile().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPf_img(filename);
			
		}else {
			PerformanceViewDTO tempDto = performanceService.view(dto.getPf_idx());
			dto.setPf_img(tempDto.getPf_img());			
		}
        performanceService.update(dto);
        
		return "redirect:/performance/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int pf_idx) throws Exception {
		performanceService.hide(pf_idx);
		
		return "redirect:/performance/list.do";
	}
	
	
	
}
