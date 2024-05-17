package com.example.demo.domain;

public class ReportVo {

	private int _code;
	private String _message;
	
	

	public ReportVo(int i, String st) {
		this._code = i;
		this._message = st;
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
