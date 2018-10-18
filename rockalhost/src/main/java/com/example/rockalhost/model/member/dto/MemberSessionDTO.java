package com.example.rockalhost.model.member.dto;

public class MemberSessionDTO {
	
	private String id;
	private String name;
	private String nickName;
	private String myBand;
	private String myGrade;
	
	@Override
	public String toString() {
		return "MemberSessionDTO [id=" + id + ", name=" + name + ", nickName=" + nickName + ", myBand=" + myBand
				+ ", myGrade=" + myGrade + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMyBand() {
		return myBand;
	}
	public void setMyBand(String myBand) {
		this.myBand = myBand;
	}
	public String getMyGrade() {
		return myGrade;
	}
	public void setMyGrade(String myGrade) {
		this.myGrade = myGrade;
	}
}
