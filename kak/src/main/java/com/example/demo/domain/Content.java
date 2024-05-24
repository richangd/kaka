package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Content {
	
	private String status;
	private String[] identifiers;
	private String name;
	private String email;
	private String email_verifiacation;
	private Object more_telephones;
	private String password;
	
	
	
	
	public Content(more_telephones ph) {
		this.more_telephones = ph;
	}
	
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
	public String getEmail() {
		return "Kim.Changbeom@kr.canon";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verifiacation() {
		return "VERIFIED";
	}
	public void setEmail_verifiacation(String email_verifiacation) {
		this.email_verifiacation = email_verifiacation;
	}
	public Object getMore_telephones() {
		return more_telephones;
	}
	public void setMore_telephones(Object[] more_telephones) {
		this.more_telephones = more_telephones;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}