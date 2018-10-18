package com.example.rockalhost.controller.band;

import java.io.File;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.service.band.AllbandService;
import com.example.rockalhost.service.band.MybandService;

@Controller
@RequestMapping("band/*")
public class AllbandController {
	
	@Inject
	MybandService MybandService;
	
	@Inject
	AllbandService allbandService;
	
	@RequestMapping("applyview.do")
	public ModelAndView applyview(@ModelAttribute AllbandDTO dto, HttpSession session) {
		System.out.println("applyview.do 호출중...");
		String b_leaderNick = (String)session.getAttribute("nickName");
		dto.setB_leaderNick(b_leaderNick);
		System.out.println("b_leaderNick="+b_leaderNick);
		ModelAndView mav = new ModelAndView();
		int checkNick = allbandService.getCheckNick(b_leaderNick);
		
		if(checkNick == 1){
			mav.setViewName("redirect:/member/home.do");
			mav.addObject("message", "failNickNameCheck");
			return mav;
		} else {
			mav.setViewName("band/apply");
			return mav;
		}
	
	}
	
	@RequestMapping("apply.do")
	public String apply(@ModelAttribute AllbandDTO dto, HttpSession session) throws Exception {
		System.out.println("apply 호출중...");		
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
		dto.setB_logo(filename);
		allbandService.apply(dto);
		return "redirect:/member/home.do";
	}	
	
	@RequestMapping("popup_checkNick/{b_name}")
	public ModelAndView popNickCheck(@PathVariable String b_name, ModelAndView mav) {
		System.out.println("popup_checkId.do id:"+b_name);
		mav.setViewName("band/checkBand");
		mav.addObject("b_name", b_name);
		return mav;
	}
	@RequestMapping("popBandCheck.do")
	public ModelAndView checkId(String b_name) {
		System.out.println("checkId.do 호출");
		boolean result = allbandService.join_idCheck(b_name);
		System.out.println("checkId.do result:"+result);
		    ModelAndView mav = new ModelAndView();
		if(result) {
			mav.setViewName("band/checkBand");
			mav.addObject("b_name", b_name);
			mav.addObject("message", "possible");    
		}else {
			mav.setViewName("band/checkBand");
			mav.addObject("message", "impossible");  	
		}
		return mav;
	}
	
}
