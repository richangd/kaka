package com.example.demo.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Content1 {
	
	private String status;
	private String[] identifiers;	
	private String name;
	public Content1(String st, String[] li, String st1) {
		this.status = st;
		this.identifiers = li;
		this.name = st1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(String[] identifiers) {
		this.identifiers = identifiers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}