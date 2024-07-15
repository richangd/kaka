package com.CanonERP.kakaoworkagent.domain;

import java.util.List;

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
	private Object more_telephones;	
	private String TELEPHONE_INTERNATIONAL;
	private String TELEPHONE_FOR_DISPLAY;
	private String TELEPHONE_VERIFICATION;
	private String BIRTHDAY;
	private String GENDER;
	private String IS_LUNAR;
	
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
	public String getTELEPHONE_INTERNATIONAL() {
		return TELEPHONE_INTERNATIONAL;
	}
	public void setTELEPHONE_INTERNATIONAL(String tELEPHONE_INTERNATIONAL) {
		TELEPHONE_INTERNATIONAL = tELEPHONE_INTERNATIONAL;
	}
	public String getTELEPHONE_FOR_DISPLAY() {
		return TELEPHONE_FOR_DISPLAY;
	}
	public void setTELEPHONE_FOR_DISPLAY(String tELEPHONE_FOR_DISPLAY) {
		TELEPHONE_FOR_DISPLAY = tELEPHONE_FOR_DISPLAY;
	}
	
	public String getTELEPHONE_VERIFICATION() {
		return TELEPHONE_VERIFICATION;
	}
	public void setTELEPHONE_VERIFICATION(String tELEPHONE_VERIFICATION) {
		TELEPHONE_VERIFICATION = tELEPHONE_VERIFICATION;
	}
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}
	
	public boolean getIS_LUNAR() {
		boolean lunal;
		
		if(IS_LUNAR.equals("2")) {
			lunal = true;
		}else {
			lunal = false;
		}
		
		return lunal;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
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