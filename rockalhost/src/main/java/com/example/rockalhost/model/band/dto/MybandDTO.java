package com.example.rockalhost.model.band.dto;

public class MybandDTO {
	
	private String b_name;
	private	String nickName; 
	private	String po_name;
	private	String gra_name;
	private	String career;
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPo_name() {
		return po_name;
	}
	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}
	public String getGra_name() {
		return gra_name;
	}
	public void setGra_name(String gra_name) {
		this.gra_name = gra_name;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "MybandDTO [b_name=" + b_name + ", nickName=" + nickName + ", po_name=" + po_name + ", gra_name="
				+ gra_name + ", career=" + career + "]";
	}
	
}