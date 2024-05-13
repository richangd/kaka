package com.example.demo.domain;

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
