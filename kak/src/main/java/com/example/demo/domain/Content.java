package com.example.demo.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Content {
	
	private String status;
	private String[] identifiers;	
	private String name;
	//private String nickname;
	private String email;
	private String email_verifiacation;
	private String telephone_international;
	private String telephone_for_display;
	private String telephone_verification;
	private Object more_telephones;
	
	
	
	
	public Content(more_telephones ph) {
		this.more_telephones = ph;
	}
	
	public Content(String st, String[] li, String st2, String st3, String st4, String st5,
			String st6, String st7, String st8, more_telephones ph) {
		
		this.status = st;
		this.identifiers = li;
		this.name = st2;
	//	this.nickname = st3;
		this.email = st4;
		this.email_verifiacation = st5;
		this.telephone_international = st6;
		this.telephone_for_display = st7;
		this.telephone_verification = st8;
		this.more_telephones = ph;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getIdentifiers() {
		
		return identifiers =  identifiers;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verifiacation() {
		return email_verifiacation;
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
/*	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
*/
	public String getTelephone_international() {
		return telephone_international;
	}

	public void setTelephone_international(String telephone_international) {
		this.telephone_international = telephone_international;
	}

	public String getTelephone_for_display() {
		return telephone_for_display;
	}

	public void setTelephone_for_display(String telephone_for_display) {
		this.telephone_for_display = telephone_for_display;
	}

	public String getTelephone_verification() {
		return telephone_verification;
	}

	public void setTelephone_verification(String telephone_verification) {
		this.telephone_verification = telephone_verification;
	}

	public void setMore_telephones(Object more_telephones) {
		this.more_telephones = more_telephones;
	}
	
	
}