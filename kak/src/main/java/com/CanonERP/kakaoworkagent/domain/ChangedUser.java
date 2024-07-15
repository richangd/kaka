package com.CanonERP.kakaoworkagent.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class ChangedUser {
	
	private String basis_time;
	private int page_number;
	private int page_size;
	
	
	
	
	public String getBasis_time() {
		return basis_time;
	}
	public void setBasis_time(String basis_time) {
		this.basis_time = basis_time;
	}
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	
	
	
}