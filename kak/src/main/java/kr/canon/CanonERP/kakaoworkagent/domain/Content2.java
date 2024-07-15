package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Content2 {
	
	private String status;
	private String[] identifiers;	
	private String name;
	private String email;
	private String email_verification;
	private Object extra;
	
	public Content2(String st, String[] li, String st1, String st2, String st3, UserExtra or) {
		this.status = st;
		this.identifiers = li;
		this.name = st1;
		this.email = st2;
		this.email_verification = st3;
		this.extra = or;
	}
	public Content2(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
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
		return extra;
	}
	public void setExtra(Object extra) {
		this.extra = extra;
	}
	
	
}