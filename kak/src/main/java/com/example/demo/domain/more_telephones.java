package com.example.demo.domain;

public class more_telephones {

	private String type;
	private String international;
	private String display;
	private String verification;
	
	public more_telephones(String st, String st1, String st2, String st3) {
		this.type = st;
		this.international = st1;
		this.display = st2;
		this.verification = st3;
	}
	
	public more_telephones() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInternational() {
		return international;
	}
	public void setInternational(String international) {
		this.international = international;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = verification;
	}
	

	
}
