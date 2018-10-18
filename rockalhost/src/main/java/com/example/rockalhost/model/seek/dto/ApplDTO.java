package com.example.rockalhost.model.seek.dto;

public class ApplDTO {
	
	private String id;
	private int idx;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Override
	public String toString() {
		return "ApplDTO [id=" + id + ", idx=" + idx + "]";
	}
	public ApplDTO() {

	}

}
