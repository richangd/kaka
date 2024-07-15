package com.CanonERP.kakaoworkagent.domain;

public class more_telephones1 {

	private String type;	
	private String display;
	private String number;	
	
	public more_telephones1(String st, String st1, String st2) {
		this.type = st;		
		this.display = st1;
		this.number = st2;
	}
	
	public more_telephones1() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
