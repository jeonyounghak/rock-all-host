package com.example.rockalhost.model.message.dto;

import java.util.Date;

public class MessageDTO {
	
	 private int idx;
	 private String sender;
	 private String receiver;
	 private String title;
	 private String content;
	 private Date regdate;
	 private String show;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "MessageDTO [idx=" + idx + ", sender=" + sender + ", receiver=" + receiver + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", show=" + show + "]";
	}	
}
