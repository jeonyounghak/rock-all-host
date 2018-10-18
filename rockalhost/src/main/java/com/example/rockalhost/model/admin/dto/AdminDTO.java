package com.example.rockalhost.model.admin.dto;

public class AdminDTO {
	
	private String id;
	private String name;
	private String email;
	private String nickName;
	private String passwd;
	private String hp1;
	private String hp2;
	private String addr;
	private String addrDt;
	private String zip;

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", name=" + name + ", email=" + email + ", nickName=" + nickName + ", passwd="
				+ passwd + ", hp1=" + hp1 + ", hp2=" + hp2 + ", addr=" + addr + ", addrDt=" + addrDt + ", zip=" + zip
				+ "]";
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
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
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
}
