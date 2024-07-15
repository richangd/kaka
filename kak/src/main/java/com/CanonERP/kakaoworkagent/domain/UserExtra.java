package com.CanonERP.kakaoworkagent.domain;

public class UserExtra {
    private Object orgunit;
    private Object user;
    
	public UserExtra(orgunit o) {
		this.orgunit = o;
	}
	public Object getOrgunit() {
		return orgunit;
	}
	public void setOrgunit(Object orgunit) {
		this.orgunit = orgunit;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}

    
}