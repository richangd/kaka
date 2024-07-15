package kr.canon.CanonERP.kakaoworkagent.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class ValidUser {

	private int _code;
	private String _message;
	private int total_pages;
	private int total_elements;
	private int size;
	private int number;
	private int number_of_elements;
	private boolean is_last;
	private boolean is_first;
	private Object[] contents;
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
	public void setContents(Object[] contents) {
		this.contents = contents;
	}

	
}
