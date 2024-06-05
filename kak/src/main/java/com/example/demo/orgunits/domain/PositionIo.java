package com.example.demo.orgunits.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

public class PositionIo {

	private Integer page_number;
	private Integer page_size;
	
	public Integer getPage_number() {
		return page_number;
	}
	public void setPage_number(Integer page_number) {
		this.page_number = page_number;
	}
	public Integer getPage_size() {
		return page_size;
	}
	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

	
}
