package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class MetadataVo {

	private int _code;
	private String _message;
	private Object profile;
	private Object synchronize_options;
	//private String[] account_categories;
	
	

	public MetadataVo(Profile pr, List sy) {
		
		this._code = 200;
		this._message = "ok";
		this.profile = pr;
		this.synchronize_options = sy;
	}


	public MetadataVo() {
		// TODO Auto-generated constructor stub
	}


	public MetadataVo(int i, String st) {
		this._code = i;
		this._message = st;
	}


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

	public Object getprofile() {
		return profile;
	}

	public void setprofile(Object profile) {
		this.profile = profile;
	}
	
	public Object getsynchronize_options() {
		return synchronize_options;
	}

	public void setsynchronize_options(Object synchronize_options) {
		this.synchronize_options = synchronize_options;
	}
	/*
	public String[] getaccount_categories() {
		return account_categories;
	}

	public void setaccount_categories(String[] account_categories) {
		this.profile = profile;
	}
*/
	
}
