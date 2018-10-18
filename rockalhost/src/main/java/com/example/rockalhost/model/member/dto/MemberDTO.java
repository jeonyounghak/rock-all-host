package com.example.rockalhost.model.member.dto;

import java.sql.Date;

public class MemberDTO {

	private int num;
	private String id; 
	private String name; 
	private String email; 
	private String nickName; 
	private String passwd; 
	private Date birth; 
	private String sex; 
	private String hp; 
	private String addr;
	private String addrDt; 
	private String zip; 
	private String career; 
	private String agreeAd; 
	private Date join_date;
	private int positionMain;
	private int positionSub;
	private int myBand;
	private int myGrade;
	private String withdrawal;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}
	public String getId() {
		return id;
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
	public int getMyBand() {
		return myBand;
	}
	public void setMyBand(int myBand) {
		this.myBand = myBand;
	}
	public int getMyGrade() {
		return myGrade;
	}
	public void setMyGrade(int myGrade) {
		this.myGrade = myGrade;
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
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
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
}
