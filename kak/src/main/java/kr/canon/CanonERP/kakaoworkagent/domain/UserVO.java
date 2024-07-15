package kr.canon.CanonERP.kakaoworkagent.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


public class UserVO {
	 
	private String userId;
	private String userName;
	private String phoneNumber;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
		
}