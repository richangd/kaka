package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class UserVO {
	
	private String supermenuname;
	private String Position;
	private String Menuname;
	
	public String getMenuname() {
		return Menuname;
	}
	public void setMenuname(String menuname) {
		Menuname = menuname;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getSupermenuname() {
		return supermenuname;
	}
	public void setSupermenuname(String supermenuname) {
		this.supermenuname = supermenuname;
	}
	
	
}