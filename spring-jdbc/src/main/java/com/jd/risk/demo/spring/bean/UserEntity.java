package com.jd.risk.demo.spring.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserEntity implements Serializable {

	private Long userId;
	private String userName;
	
	public UserEntity() {
		
	}
	
	public UserEntity(Long userId,String userName){
		
		this.userId = userId;
		this.userName = userName;
		
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
