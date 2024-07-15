package com.CanonERP.kakaoworkagent.orgunits.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ChangeOrgVo {

	private Integer _code;
	private String _message;
	private Integer total_pages;
	private Integer total_elements;
	private Integer size;
	private String number;
	private Integer number_of_elements;
	private Boolean is_last;
	private Boolean is_first;
	private Object contents;
	
	
	
	public ChangeOrgVo() {
		// TODO Auto-generated constructor stub
	}
	public ChangeOrgVo(int i, String st, int j, int k, int l, String string, int n, boolean b, boolean c,
			List rco) {
		this._code = i;
		this._message = st;
		this.total_pages = j;
		this.total_elements = k;
		this.size = l;
		this.number = string;
		this.number_of_elements = n;
		this.is_last = b;
		this.is_first = c;
		this.contents = rco;
	}
	public Integer get_code() {
		return _code;
	}
	public void set_code(Integer _code) {
		this._code = _code;
	}
	public String get_message() {
		return _message;
	}
	public void set_message(String _message) {
		this._message = _message;
	}
	public Integer getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}
	public Integer getTotal_elements() {
		return total_elements;
	}
	public void setTotal_elements(Integer total_elements) {
		this.total_elements = total_elements;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getNumber_of_elements() {
		return number_of_elements;
	}
	public void setNumber_of_elements(Integer number_of_elements) {
		this.number_of_elements = number_of_elements;
	}
	public Boolean getIs_last() {
		return is_last;
	}
	public void setIs_last(Boolean is_last) {
		this.is_last = is_last;
	}
	public Boolean getIs_first() {
		return is_first;
	}
	public void setIs_first(Boolean is_first) {
		this.is_first = is_first;
	}
	public Object getContents() {
		return contents;
	}
	public void setContents(Object contents) {
		this.contents = contents;
	}
	
		
}
