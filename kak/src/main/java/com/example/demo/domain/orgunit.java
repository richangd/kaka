package com.example.demo.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class orgunit {
	
	private Object departments;
	private String position_code;
	
	public orgunit(departments dp, String st1) {
		this.departments = dp;
		this.position_code = st1;
	}
	public Object getDepartments() {
		return departments;
	}
	public void setDepartments(Object departments) {
		this.departments = departments;
	}
	public String getPosition_code() {
		return position_code;
	}
	public void setPosition_code(String position_code) {
		this.position_code = position_code;
	}
	
	
	
	
}