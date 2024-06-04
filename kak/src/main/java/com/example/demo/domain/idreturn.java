package com.example.demo.domain;

public class idreturn {

	private String result;
	private String reason;
	private int _code;
	private String _message;
	
	public idreturn(String result, String reason, int _code, String _message) {
		super();
		this.result = result;
		this.reason = reason;
		this._code = _code;
		this._message = _message;
	}

	public idreturn() {
		// TODO Auto-generated constructor stub
	}

	public String getResult() {
		return this.result = "SUCCESS";
	}

	public void setResult(String result) {
		this.result = "SUCCESS";
	}

	public String getReason() {
		return this.result = "AUTH_SUCCESS";
	}

	public void setReason(String reason) {
		this.reason = "AUTH_SUCCESS";
	}

	public int get_code() {
		return this._code =  200;
	}

	public void set_code(int _code) {
		this._code = 200;
	}

	public String get_message() {
		return this._message = "OK";
	}

	public void set_message(String _message) {
		this._message = "OK";
	}
	
	
	
	
}
