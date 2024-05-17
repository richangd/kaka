package com.example.demo.domain;

public class agentVo {

	private int _code;
	private String _message;
	private String[] capabilities;	

	public int get_code() {
		return _code = 200;
	}

	public void set_code(int _code) {
		this._code = 200;
	}

	public String get_message() {
		return _message = "ok";
	}

	public void setReason(String _message) {
		this._message = "ok";
	}

	public String[] getcapabilities() {
		String g1 = "agent";
		String g2 = "user";
		String g3 = "Login";
		String g4 = "orgUnit";
		
		return capabilities =  new String[]{g1,g2,g3,g4};
	}

	public void setcapabilities(String[] capabilities) {
		this.capabilities = capabilities;
	}

	
}
