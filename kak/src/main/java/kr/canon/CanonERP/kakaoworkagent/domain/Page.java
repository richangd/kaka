package kr.canon.CanonERP.kakaoworkagent.domain;

import lombok.Data;
import lombok.NoArgsConstructor;



public class Page {

	private String page_number;	
	
	public Page(String st) {
		page_number = st;
	}
	public String getpage_number() {
		return page_number;
	}
	public void setpage_number(String total_count) {
		page_number = total_count;
	}	
}
