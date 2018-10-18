package com.example.rockalhost.model.recruit.dto;

import java.util.Date;

public class ReplyDTO {
	private int rno; //댓글 번호
	private int idx; //게시물 번호
	private String replytext; //댓글 내용
	private String replyer; //댓글 작성자 id
	private String nickName; //댓글 작성자 이름
	private Date reg_date; //java.util.Date, 작성일자
	private Date updatedate; //수정일자
	private String secret_reply; //비밀댓글 여부
	private String writer; //member 테이블의 id
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getSecret_reply() {
		return secret_reply;
	}
	public void setSecret_reply(String secret_reply) {
		this.secret_reply = secret_reply;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", idx=" + idx + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", nickName=" + nickName + ", reg_date=" + reg_date + ", updatedate=" + updatedate + ", secret_reply="
				+ secret_reply + ", writer=" + writer + "]";
	}


}
