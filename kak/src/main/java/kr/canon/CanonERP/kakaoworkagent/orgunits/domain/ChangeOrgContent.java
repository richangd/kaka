package kr.canon.CanonERP.kakaoworkagent.orgunits.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ChangeOrgContent {
	
	
	private String status;
	private String code;
	private String name;
	private String parent_code;
	private boolean is_private;
	private Integer order;
	
	public ChangeOrgContent(String st, String st1, String st2, String st3, boolean b, int i) {
		this.status = st;
		this.code = st1;
		this.name = st2;
		this.parent_code = st3;
		this.is_private = b;
		this.order = i;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public boolean isIs_private() {
		return is_private;
	}
	public void setIs_private(boolean is_private) {
		this.is_private = is_private;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
}
