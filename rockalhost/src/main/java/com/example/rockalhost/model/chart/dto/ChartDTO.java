package com.example.rockalhost.model.chart.dto;

public class ChartDTO {
	private String c_name;
	private int c_count;
	
	@Override
	public String toString() {
		return "Pf_ChartDTO [c_name=" + c_name + ", c_count=" + c_count + "]";
	}
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}

}
