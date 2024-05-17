package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Content {
	
	private String status;
	private String[] identifiers;
	private String name;
	
	public String getStatus() {
		return "ACTIVE";
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getIdentifiers() {
		String g1 = "김창범";
		String g3 = "Kim.Changbeom@kr.canon";
		
		return identifiers =  new String[]{g1,g3};
		
	}
	public void setIdentifiers(String[] identifiers) {
		this.identifiers = identifiers;
	}
	public String getName() {
		return "테스트";
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}