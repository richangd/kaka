package kr.canon.CanonERP.kakaoworkagent.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class Valid {
	
	private String basistime;
	private String page_number;
	
	
	public String getBasistime() {
		return basistime;
	}
	public void setBasistime(String basistime) {
		this.basistime = basistime;
	}
	public String getPage_number() {
		return page_number;
	}
	public void setPage_number(String page_number) {
		this.page_number = page_number;
	}
	
}