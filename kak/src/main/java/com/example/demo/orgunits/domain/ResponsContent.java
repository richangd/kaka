package com.example.demo.orgunits.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponsContent {
	
	
	private String code;
	private Integer level;
	private String name;
	
	public ResponsContent(String st, int i, String st1) {
		this.code = st;
		this.level = i;
		this.name = st1;
	}
	
	public ResponsContent() {
	
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
