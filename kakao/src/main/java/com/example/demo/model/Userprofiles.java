package com.example.demo.model;

/**
 * 
 */
public class Userprofiles {

	private String identifier;
	private String password;
	public Userprofiles(String identifier, String password) {
		super();
		this.identifier = identifier;
		this.password = password;
	}
	
	public String getidentifier() {
		return identifier;
	}
	
	public void setidentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	
	
	
}
