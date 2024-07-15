package kr.canon.CanonERP.kakaoworkagent.domain;

public class Logindata {
    private String identifier;
    

    public Logindata(String st) {
    	this.identifier = st;
	}

	public String getidentifier() {    	
		return identifier;
    }
    
    public void setidentifier(String identifier) {
        this.identifier = identifier;
    }

    
}