package com.example.rockalhost.model.band.dto;

import java.util.Date;

public class AllbandViewDTO {

	private int b_idx;
	private String b_name; 
	private String gn_name; 
	private int b_num; 
	private String b_leaderNick; 
	private String ar_name; 
	private String b_logo;
	private Date found_date;
	private String apply;
	private String show; //밴드 탈퇴 시 출력 여부
  	private Date reg_date;
	private String description;
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getGn_name() {
		return gn_name;
	}
	public void setGn_name(String gn_name) {
		this.gn_name = gn_name;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_leaderNick() {
		return b_leaderNick;
	}
	public void setB_leaderNick(String b_leaderNick) {
		this.b_leaderNick = b_leaderNick;
	}
	public String getAr_name() {
		return ar_name;
	}
	public void setAr_name(String ar_name) {
		this.ar_name = ar_name;
	}
	public String getB_logo() {
		return b_logo;
	}
	public void setB_logo(String b_logo) {
		this.b_logo = b_logo;
	}
	public Date getFound_date() {
		return found_date;
	}
	public void setFound_date(Date found_date) {
		this.found_date = found_date;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AllbandViewDTO [b_idx=" + b_idx + ", b_name=" + b_name + ", gn_name=" + gn_name + ", b_num=" + b_num
				+ ", b_leaderNick=" + b_leaderNick + ", ar_name=" + ar_name + ", b_logo=" + b_logo + ", found_date="
				+ found_date + ", apply=" + apply + ", show=" + show + ", reg_date=" + reg_date + ", description="
				+ description + "]";
	}
	
}