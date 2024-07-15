package com.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class editability {

	
	private boolean name;
	private boolean nickname;
	private boolean email;
	private boolean telephone;
	private Object telephones;
	private boolean birthday;
	private boolean gender;
	private boolean photo_url;
	private boolean is_lunar;
	
	public editability(telephones te) {
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.telephone = telephone;
		this.telephones = te;
		this.birthday = birthday;
		this.gender = gender;
		this.is_lunar = is_lunar;
		
	} 
	public editability(boolean b, boolean c, boolean d, List<com.CanonERP.kakaoworkagent.domain.telephones> te, boolean e,
			boolean f, boolean g) {
		this.name = b;
		this.nickname = c;
		this.email = d;
		this.telephone = e;
		this.telephones = te;
		this.birthday = f;
		this.gender = g;
		this.is_lunar = g;
	}
	public editability(String st, String st1, String st2, String st3,
			telephones te, String st6, String st7, String st8, String st9) {
		this.name = st.equals("1");
		this.nickname = st1.equals("1");
		this.email = st2.equals("1");
		this.telephone = st3.equals("1");
		this.telephones = te;
		this.birthday = st6.equals("1");
		this.photo_url = st7.equals("1");
		this.gender = st8.equals("1");
		this.is_lunar = st9.equals("1");
		
	}
	public boolean getName() {
		return name;
	}
	public void setName(boolean name) {
		this.name = name;
	}
	public boolean getNickname() {
		return nickname;
	}
	public void setNickname(boolean nickname) {
		this.nickname = nickname;
	}
	public boolean getEmail() {
		return email;
	}
	public void setEmail(boolean email) {
		this.email = email;
	}
	public boolean getTelephone() {
		return telephone;
	}
	public void setTelephone(boolean telephone) {
		this.telephone = telephone;
	}
	public Object getTelephones() {
		return telephones;
	}
	public void setTelephones(Object telephones) {
		this.telephones = telephones;
	}
	public boolean getBirthday() {
		return birthday;
	}
	public void setBirthday(boolean birthday) {
		this.birthday = birthday;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(boolean photo_url) {
		this.photo_url = photo_url;
	}
	public boolean getIs_lunar() {
		return is_lunar;
	}
	public void setIs_lunar(boolean is_lunar) {
		this.is_lunar = is_lunar;
	}

	
}
