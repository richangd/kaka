package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class synchronize_options {

	
	private String display_name;
	private String value;
	
	
	public synchronize_options(String st, String st2) {
		this.display_name = st;
		this.value = st2;
		
	}
	public String getdisplay_name() {
		return display_name;
	}
	public void setdisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getvalue() {
		return value;
	}
	public void setvalue(String value) {
		this.value = value;
	}
		

	

	
}
