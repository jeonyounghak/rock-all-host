package com.example.rockalhost.controller.band;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.rockalhost.model.band.dto.AllbandDTO;
import com.example.rockalhost.model.band.dto.AllbandViewDTO;
import com.example.rockalhost.model.band.dto.MybandDTO;
import com.example.rockalhost.model.member.dto.MemberDTO;
import com.example.rockalhost.service.band.AllbandService;
import com.example.rockalhost.service.band.MybandService;
import com.example.rockalhost.service.member.MemberService;

@Controller
@RequestMapping("myband/*")
public class MybandController {

	@Inject
	MybandService MybandService;
	@Inject
	MemberService MemberService;
	@Inject
	AllbandService AllbandService;
	
	@RequestMapping("mylist.do")
	public ModelAndView list(HttpSession session) throws Exception {
		int band = (int)session.getAttribute("band");
		List<MybandDTO> list = MybandService.list(band);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("band/myband");
		mav.addObject("map", map); 
		return mav; 
	}
	@RequestMapping("leaderlist.do")
	public ModelAndView leaderlist(HttpSession session) throws Exception {
		int band = (int)session.getAttribute("band");
		List<MybandDTO> list = MybandService.leaderlist(band);
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); 
		map.put("count", list.size());
		mav.setViewName("band/leaderBand");
		mav.addObject("map", map); 
		return mav; 
	}
	@RequestMapping("temperProfile/{nickName}")
	public ModelAndView temperProfile(@PathVariable String nickName, ModelAndView mav) {
		System.out.println("temperProfile.do 호출중..");				
		MemberDTO dto = MybandService.temperProfile(nickName);	
		System.out.println("nickname="+nickName);
		mav.addObject("dto", dto);		
		mav.setViewName("/band/temperProfile");
		return mav;		
	}
	@RequestMapping("temperUpdate.do")
	public ModelAndView temperUpdate(MemberDTO dto, ModelAndView mav) {
	System.out.println("update.do 호출중..");				
	MybandService.temperUpdate(dto);	
	mav.setViewName("redirect:leaderlist.do");
	return mav;		
	}
	@RequestMapping("temperDelete.do")
	public ModelAndView temperDelete(MemberDTO dto, ModelAndView mav) {
	System.out.println("delete.do 호출중..");				
	MybandService.temperDelete(dto);	
	mav.setViewName("redirect:leaderlist.do");
	return mav;		
	}
	@RequestMapping("mytemperDelete.do")
	public ModelAndView mytemperDelete(MemberDTO dto, ModelAndView mav, HttpSession session) {
	System.out.println("mytemperDelete 호출중..");				
	MybandService.mytemperDelete(dto);	
	session.setAttribute("nickName", dto.getNickName());
	session.setAttribute("grade", dto.getMyGrade());
	session.setAttribute("band", dto.getMyBand());
	mav.setViewName("home");
	return mav;		
	}
	@RequestMapping("mybandview.do")
	public ModelAndView adminapply(AllbandViewDTO dto, ModelAndView mav, HttpSession session) throws Exception {
		System.out.println("mybandview.do 호출중..");
		int b_idx = (int)session.getAttribute("band"); 
		dto.setB_idx(b_idx);
		dto=AllbandService.mybandview(b_idx);	
		System.out.println("dto="+dto);			
		mav.addObject("dto", dto);		
		mav.setViewName("band/mybandview");
		return mav;		
	}
	@RequestMapping("mybandupdate.do")
	public ModelAndView mybandupdate(AllbandDTO dto, ModelAndView mav, HttpSession session) {
		System.out.println("mybandupdate 호출중..");				
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
			dto.setB_logo(filename);
		}else {//새로운 첨부 파일이 없을 때
			//기존에 첨부한 파일 정보를 가져옴
			AllbandViewDTO dto2	= AllbandService.mybandview(dto.getB_idx());
			dto.setB_logo(dto2.getB_logo());
		}
			String nickName = (String)session.getAttribute("nickName");
			dto.setB_leaderNick(nickName);
			AllbandService.mybandupdate(dto);	
			System.out.println("dto="+dto);	
			mav.addObject("dto", dto);
			mav.setViewName("redirect:mybandview.do");
			return mav;
			}
		}
