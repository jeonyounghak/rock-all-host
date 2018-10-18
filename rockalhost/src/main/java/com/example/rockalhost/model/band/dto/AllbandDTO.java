package com.example.rockalhost.model.band.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class AllbandDTO {
	private int b_idx;
  	private String b_name;
  	private int b_genre; //genre 테이블에 g_type과 연결
  	private int b_num; //인원수
  	private String b_leaderNick;
  	private int b_area; //area 테이블에 a_idx와 연결
  	private String description; //소개글
  	private String approval; //밴드 승인 여부
  	private String show; //밴드 탈퇴 시 출력 여부
  	private Date found_date;
  	private String b_logo;
  	private MultipartFile imgFile;
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
	public int getB_genre() {
		return b_genre;
	}
	public void setB_genre(int b_genre) {
		this.b_genre = b_genre;
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
	public int getB_area() {
		return b_area;
	}
	public void setB_area(int b_area) {
		this.b_area = b_area;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public Date getFound_date() {
		return found_date;
	}
	public void setFound_date(Date found_date) {
		this.found_date = found_date;
	}
	public String getB_logo() {
		return b_logo;
	}
	public void setB_logo(String b_logo) {
		this.b_logo = b_logo;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	@Override
	public String toString() {
		return "AllbandDTO [b_idx=" + b_idx + ", b_name=" + b_name + ", b_genre=" + b_genre + ", b_num=" + b_num
				+ ", b_leaderNick=" + b_leaderNick + ", b_area=" + b_area + ", description=" + description
				+ ", approval=" + approval + ", show=" + show + ", found_date=" + found_date + ", b_logo=" + b_logo
				+ ", imgFile=" + imgFile + "]";
	}
	
}
