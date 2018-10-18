package com.example.rockalhost.model.recruit.dto;

import java.util.Arrays;
import java.util.Date;

public class RecruitDTO {
	
	private int num;
	private int idx; //게시물번호
	private int type; //게시판 분류
	private String writer; //작성자
	private String subject; //제목
	private String passwd; //수정/삭제 비번
	private Date reg_date; //작성일자
	private int recommend; //추천수
	private int readcount; //조회수
	private int cnt;//댓글 수
	private int ref; //게시물그룹
	private int re_step; //게시물그룹의 순번
	private int re_level; //답변 단계
	private String content; //본문
	private String ip; //작성자 ip
	private String[] files;
	private String show;
	private int re_num; //모집인원
	private int re_position; //모집 포지션
	private int r_area; //모집지역 area 테이블에 idx와 연동
	private Date close_date; //마감일자
	private String re_state;
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public Date getReg_date() {
		return reg_date;
	}


	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public int getRef() {
		return ref;
	}


	public void setRef(int ref) {
		this.ref = ref;
	}


	public int getRe_step() {
		return re_step;
	}


	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}


	public int getRe_level() {
		return re_level;
	}


	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String[] getFiles() {
		return files;
	}


	public void setFiles(String[] files) {
		this.files = files;
	}


	public String getShow() {
		return show;
	}


	public void setShow(String show) {
		this.show = show;
	}


	public int getRe_num() {
		return re_num;
	}


	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}


	public int getRe_position() {
		return re_position;
	}


	public void setRe_position(int re_position) {
		this.re_position = re_position;
	}


	public int getR_area() {
		return r_area;
	}


	public void setR_area(int r_area) {
		this.r_area = r_area;
	}


	public Date getClose_date() {
		return close_date;
	}


	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}


	public String getRe_state() {
		return re_state;
	}


	public void setRe_state(String re_state) {
		this.re_state = re_state;
	}

	@Override
	public String toString() {
		return "RecruitDTO [num=" + num + ", idx=" + idx + ", type=" + type + ", writer=" + writer + ", subject="
				+ subject + ", passwd=" + passwd + ", reg_date=" + reg_date + ", recommend=" + recommend
				+ ", readcount=" + readcount + ", cnt=" + cnt + ", ref=" + ref + ", re_step=" + re_step + ", re_level="
				+ re_level + ", content=" + content + ", ip=" + ip + ", files=" + Arrays.toString(files) + ", show="
				+ show + ", re_num=" + re_num + ", re_position=" + re_position + ", r_area=" + r_area + ", close_date="
				+ close_date + ", re_state=" + re_state + "]";
	}

	public RecruitDTO() {
	}

}
