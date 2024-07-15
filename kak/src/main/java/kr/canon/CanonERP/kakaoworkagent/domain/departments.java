package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class departments {
		
	private String code;
	private Boolean is_main;
	private Boolean is_leader;
	private String responsibility_code;
	
	public departments(String st, boolean b, boolean c, String st1) {
		this.code = st;
		this.is_main = b;
		this.is_leader = c;
		this.responsibility_code = st1;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getIs_main() {
		return is_main;
	}
	public void setIs_main(Boolean is_main) {
		this.is_main = is_main;
	}
	public Boolean getIs_leader() {
		return is_leader;
	}
	public void setIs_leader(Boolean is_leader) {
		this.is_leader = is_leader;
	}
	public String getResponsibility_code() {
		return responsibility_code;
	}
	public void setResponsibility_code(String responsibility_code) {
		this.responsibility_code = responsibility_code;
	}
	
		
}