package com.example.demo.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Content {
	
	private String status;
	private String[] identifiers;	
	private String name;
	private String nickname;
	private String email;
	private String email_verification;
	private String telephone_international;
	private String telephone_for_display;
	private String telephone_verification;
	private Object more_telephones;
	private String birthday;
	private String gender;
	private boolean is_lunar;
	private String photo_url;
	
	
	
	
	public Content(more_telephones ph) {
		this.more_telephones = ph;
	}
	
	public Content(String st, String[] li, String st2, String st3, String st4, String st5,
			String st6, String st7, String st8, List ph, String st9, String st10, boolean st11, String st12) {
		
		this.status = st;
		this.identifiers = li;
		this.name = st2;
		this.nickname = st3;
		this.email = st4;
		this.email_verification = st5;
		this.telephone_international = st6;
		this.telephone_for_display = st7;
		this.telephone_verification = st8;
		this.more_telephones = ph;
		this.birthday = st9;
		this.gender = st10;
		this.is_lunar = st11;
		this.photo_url = st12;
	}

	public Content(String string, String[] li, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, com.example.demo.domain.more_telephones ph, String string9,
			String string10, boolean b, String string11) {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Object getMore_telephones() {
		return more_telephones;
	}

	public void setMore_telephones(Object more_telephones) {
		this.more_telephones = more_telephones;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isIs_lunar() {
		return is_lunar;
	}

	public void setIs_lunar(boolean is_lunar) {
		this.is_lunar = is_lunar;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}


	
}