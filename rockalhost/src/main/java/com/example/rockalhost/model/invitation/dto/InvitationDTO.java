package com.example.rockalhost.model.invitation.dto;

import java.sql.Date;

public class InvitationDTO {
	
	private int iv_idx;
	private String user_id;
	private int pf_idx;
	private String pf_title;
	private String b_name;
	private String pf_location;
	private Date pf_date;
	private String pf_time;
	private int count;
	private String issue;
	private Date apply_date;
	private String inviCode;
	
	@Override
	public String toString() {
		return "InvitationDTO [iv_idx=" + iv_idx + ", user_id=" + user_id + ", pf_idx=" + pf_idx + ", pf_title="
				+ pf_title + ", b_name=" + b_name + ", pf_location=" + pf_location + ", pf_date=" + pf_date
				+ ", pf_time=" + pf_time + ", count=" + count + ", issue=" + issue + ", apply_date=" + apply_date
				+ ", inviCode=" + inviCode + "]";
	}
	
	public String getInviCode() {
		return inviCode;
	}
	public void setInviCode(String inviCode) {
		this.inviCode = inviCode;
	}
	public int getIv_idx() {
		return iv_idx;
	}
	public void setIv_idx(int iv_idx) {
		this.iv_idx = iv_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPf_idx() {
		return pf_idx;
	}
	public void setPf_idx(int pf_idx) {
		this.pf_idx = pf_idx;
	}
	public String getPf_title() {
		return pf_title;
	}
	public void setPf_title(String pf_title) {
		this.pf_title = pf_title;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getPf_location() {
		return pf_location;
	}
	public void setPf_location(String pf_location) {
		this.pf_location = pf_location;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public Date getApply_date() {
		return apply_date;
	}
	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}
}
