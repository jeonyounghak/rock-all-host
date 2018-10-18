package com.example.rockalhost.service.chart;

import org.json.simple.JSONObject;

public interface GoogleChartService {
	
	public JSONObject getChartGenre();
	public JSONObject getChartArea();
	public JSONObject getChartBand();
	public JSONObject getChartSex();
	public JSONObject getChartAge();
	public JSONObject getChartPosition();
	public JSONObject getChartB_area();
	public JSONObject getChartB_genre();

}
