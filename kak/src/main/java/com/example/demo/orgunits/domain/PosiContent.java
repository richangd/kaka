package com.example.demo.orgunits.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

public class PosiContent {
	
	
	
	private String code;
	private Integer level;
	private String name;
	
	public PosiContent(String st, Integer i, String st1) {		
		this.code = st;
		this.name = st1;
		this.level = i;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
