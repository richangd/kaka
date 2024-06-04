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
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int get_code() {
		return _code;
	}

	public void set_code(int _code) {
		this._code = _code;
	}

	public String get_message() {
		return _message;
	}

	public void set_message(String _message) {
		this._message = _message;
	}


	
	
	
}
