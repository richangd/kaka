package com.CanonERP.kakaoworkagent.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


public class ValidVo {
	
	private int _code;
	private String _message;
	private int total_pages;
	private int total_elements;
	private int size;
	private String number;
	private int number_of_elements;
	private boolean is_last;
	private boolean is_first;
	private Object contents;
	
	
	public ValidVo(int i, String st, int j, int k, int l, String string, int n, boolean b, boolean c, List ct) {
		this._code = i;
		this._message = st;
		this.total_pages = j;
		this.total_elements = k;
		this.size = l;
		this.number = string;
		this.number_of_elements = n;
		this.is_last = b;
		this.is_first = c;
		this.contents = ct;
	}
	
	public ValidVo() {
		// TODO Auto-generated constructor stub
	}

	public int get_code() {
		return _code;
	}
	public void set_code(int _code) {
		this._code = _code;
	}
	public String get_message() {
		return _message;
	}
	public void set_message(String _message) {
		this._message = _message;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getTotal_elements() {
		return total_elements;
	}
	public void setTotal_elements(int total_elements) {
		this.total_elements = total_elements;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getNumber_of_elements() {
		return number_of_elements;
	}
	public void setNumber_of_elements(int number_of_elements) {
		this.number_of_elements = number_of_elements;
	}
	public boolean isIs_last() {
		return is_last;
	}
	public void setIs_last(boolean is_last) {
		this.is_last = is_last;
	}
	public boolean isIs_first() {
		return is_first;
	}
	public void setIs_first(boolean is_first) {
		this.is_first = is_first;
	}
	public Object getContents() {
		return contents;
	}
	public void setContents(Object contents) {
		this.contents = contents;
	}
	
}