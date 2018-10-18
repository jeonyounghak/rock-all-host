package com.example.rockalhost.model.performance.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class PerformanceViewDTO {
	private int pf_idx;
	private String writer;
	private String pf_title;
	private String gn_name;
	private int pf_seats;
	private int remainder;
	private String b_name;
	private String ar_name;
	private String pf_runningTime;
	private String pf_location;
	private String content;
	private Date pf_date;
	private String pf_time;
	private String show;
	private int recommend;
	private int readcount;
    private Date reg_date;
    private String pf_img;
    private MultipartFile imgFile;
    private float score;
   
	@Override
	public String toString() {
		return "PerformanceViewDTO [pf_idx=" + pf_idx + ", writer=" + writer + ", pf_title=" + pf_title + ", gn_name="
				+ gn_name + ", pf_seats=" + pf_seats + ", remainder=" + remainder + ", b_name=" + b_name + ", ar_name="
				+ ar_name + ", pf_runningTime=" + pf_runningTime + ", pf_location=" + pf_location + ", content="
				+ content + ", pf_date=" + pf_date + ", pf_time=" + pf_time + ", show=" + show + ", recommend="
				+ recommend + ", readcount=" + readcount + ", reg_date=" + reg_date + ", pf_img=" + pf_img
				+ ", imgFile=" + imgFile + ", score=" + score + "]";
	}
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getRemainder() {
		return remainder;
	}
	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}
	public int getPf_idx() {
		return pf_idx;
	}
	public void setPf_idx(int pf_idx) {
		this.pf_idx = pf_idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPf_title() {
		return pf_title;
	}
	public void setPf_title(String pf_title) {
		this.pf_title = pf_title;
	}
	public String getGn_name() {
		return gn_name;
	}
	public void setGn_name(String gn_name) {
		this.gn_name = gn_name;
	}
	public int getPf_seats() {
		return pf_seats;
	}
	public void setPf_seats(int pf_seats) {
		this.pf_seats = pf_seats;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getAr_name() {
		return ar_name;
	}
	public void setAr_name(String ar_name) {
		this.ar_name = ar_name;
	}
	public String getPf_runningTime() {
		return pf_runningTime;
	}
	public void setPf_runningTime(String pf_runningTime) {
		this.pf_runningTime = pf_runningTime;
	}
	public String getPf_location() {
		return pf_location;
	}
	public void setPf_location(String pf_location) {
		this.pf_location = pf_location;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPf_date() {
		return pf_date;
	}
	public void setPf_date(Date pf_date) {
		this.pf_date = pf_date;
	}
	public String getPf_time() {
		return pf_time;
	}
	public void setPf_time(String pf_time) {
		this.pf_time = pf_time;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getPf_img() {
		return pf_img;
	}
	public void setPf_img(String pf_img) {
		this.pf_img = pf_img;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
}
