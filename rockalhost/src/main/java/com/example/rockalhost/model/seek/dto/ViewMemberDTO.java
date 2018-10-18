package com.example.rockalhost.model.seek.dto;

import java.sql.Date;

public class ViewMemberDTO {

	private String id; 
	private String name; 
	private String email; 
	private String nickName; 
	private String passwd; 
	private Date birth; 
	private String sex; 
	private int hp; 
	private String addr;
	private String addrDt; 
	private String zip; 
	private String career; 
	private String agreeAd; 
	private Date join_date;
	private int positionMain;
	private int positionSub;
	private String myBand;
	private int myGrade;
	

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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getAddrDt() {
		return addrDt;
	}


	public void setAddrDt(String addrDt) {
		this.addrDt = addrDt;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCareer() {
		return career;
	}


	public void setCareer(String career) {
		this.career = career;
	}


	public String getAgreeAd() {
		return agreeAd;
	}


	public void setAgreeAd(String agreeAd) {
		this.agreeAd = agreeAd;
	}


	public Date getJoin_date() {
		return join_date;
	}


	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}


	public int getPositionMain() {
		return positionMain;
	}


	public void setPositionMain(int positionMain) {
		this.positionMain = positionMain;
	}


	public int getPositionSub() {
		return positionSub;
	}


	public void setPositionSub(int positionSub) {
		this.positionSub = positionSub;
	}


	public String getMyBand() {
		return myBand;
	}


	public void setMyBand(String myBand) {
		this.myBand = myBand;
	}


	public int getMyGrade() {
		return myGrade;
	}


	public void setMyGrade(int myGrade) {
		this.myGrade = myGrade;
	}

	@Override
	public String toString() {
		return "ViewMemberDTO [id=" + id + ", name=" + name + ", email=" + email + ", nickName=" + nickName
				+ ", passwd=" + passwd + ", birth=" + birth + ", sex=" + sex + ", hp=" + hp + ", addr=" + addr
				+ ", addrDt=" + addrDt + ", zip=" + zip + ", career=" + career + ", agreeAd=" + agreeAd + ", join_date="
				+ join_date + ", positionMain=" + positionMain + ", positionSub=" + positionSub + ", myBand=" + myBand
				+ ", myGrade=" + myGrade + "]";
	}

	public ViewMemberDTO() {
	} 
	
}
