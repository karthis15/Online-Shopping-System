package com.example.online_shopping.service.dto;

public class LoginDTO {
	
	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}

	public LoginDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	
	

}
