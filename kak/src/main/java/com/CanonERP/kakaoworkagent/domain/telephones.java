package com.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class telephones {
	
	private boolean mobile;
	private boolean fixed_line;
	 
	public telephones(boolean b, boolean c) {
		this.mobile = b;
		this.fixed_line = c;
	}
	public telephones(String st4, String st5) {
		this.mobile = st4.equals("1");
		this.fixed_line = st5.equals("1");
	}
	public boolean isMobile() {
		return mobile;
	}
	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}
	public boolean isFixed_line() {
		return fixed_line;
	}
	public void setFixed_line(boolean fixed_line) {
		this.fixed_line = fixed_line;
	}
	

	
	
}
