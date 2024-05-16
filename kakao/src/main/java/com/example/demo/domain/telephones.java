package com.example.demo.domain;

import java.util.List;

public class telephones {
	
	private boolean mobile;
	private boolean fixed_line;
	 
	public telephones(boolean b, boolean c) {
		this.mobile = b;
		this.fixed_line = c;
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
