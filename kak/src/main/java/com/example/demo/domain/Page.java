package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;



public class Page {

	private int page_number;
	private int page_size;
	
	public Page(int i, int j) {
		page_number = i;
		page_size = j;
	}
	public int getpage_number() {
		return page_number;
	}
	public void setpage_number(int total_count) {
		page_number = total_count;
	}
	public int getpage_size() {
		return page_size;
	}
	public void setpage_size(int total_page) {
		page_size = total_page;
	}

	
	
}
