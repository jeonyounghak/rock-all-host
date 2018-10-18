package com.example.rockalhost.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rockalhost.service.chart.GoogleChartService;

@RestController
@RequestMapping("chart/*")
public class GoogleChartController {
	
	@Inject
	GoogleChartService googleChartService;	

	@RequestMapping("pf_genre.do")
	public JSONObject pf_genre() {
		return googleChartService.getChartGenre();
	}
	
	@RequestMapping("pf_area.do")
	public JSONObject pf_area() {
		return googleChartService.getChartArea();
	}
	
	@RequestMapping("pf_band.do")
	public JSONObject pf_band() {
		return googleChartService.getChartBand();
	}
	
	@RequestMapping("m_sex.do")
	public JSONObject m_sex() {
		return googleChartService.getChartSex();
	}
	
	@RequestMapping("m_age.do")
	public JSONObject m_age() {
		return googleChartService.getChartAge();
	}
	
	@RequestMapping("m_postion.do")
	public JSONObject m_postion() {
		return googleChartService.getChartPosition();
	}
	
	@RequestMapping("b_area.do")
	public JSONObject b_area() {
		return googleChartService.getChartB_area();
	}
	
	@RequestMapping("b_genre.do")
	public JSONObject b_genre() {
		return googleChartService.getChartB_genre();
	}

}
