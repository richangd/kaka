package com.example.demo.domain;

import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Content0 {
	
	private String status;
	private String[] identifiers;	
	private String name;
	private String email;
	private String email_verification;
	private Object extra;
	private String CODE; 
	private String IS_MAIN; 
	private String IS_LEADER; 
	private String RESPONSIBILITY_CODE; 
	private String POSITION_CODE;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getIdentifiers() {
		return new String[] {name, email};
	}
	public void setIdentifiers(String[] identifiers) {
		this.identifiers =  new String[] {name, email};
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verification() {
		return email_verification;
	}
	public void setEmail_verification(String email_verification) {
		this.email_verification = email_verification;
	}
	public Object getExtra() {
		boolean is_main;
		boolean is_leader;
		
		if(IS_MAIN.equals("1")) {
			is_main = true;
		}else {
			is_main = false;
		}
		
		if(IS_LEADER.equals("1")) {
			is_leader = true;
		}else {
			is_leader = false;
		}
		
		
		departments dp = new departments(CODE, is_main, is_leader, RESPONSIBILITY_CODE);
		orgunit o = new orgunit(dp, POSITION_CODE);
		UserExtra or = new UserExtra(o);
	    
		
		return or;
	}
	public void setExtra(Object extra) {
		this.extra = extra;
	}
	
	
	
}