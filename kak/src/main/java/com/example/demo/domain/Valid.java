package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Valid {
	
	private int basistime;
	private int page_number;
	private int page_size;
	
	
	public int getBasistime() {
		return basistime;
	}
	public void setBasistime(int basistime) {
		this.basistime = basistime;
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