package com.example.demo.domain;

public class Param {
    private String identifier;
    private String password;
    private Object extra;    

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
    
    public Object getextra() {
        return extra;
    }

    public void setextra(Object extra) {
        this.extra = extra;
    }
    

}