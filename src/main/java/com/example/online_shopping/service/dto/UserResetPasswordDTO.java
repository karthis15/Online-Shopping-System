package com.example.online_shopping.service.dto;

public class UserResetPasswordDTO {

	private String emailId;

	private String ResetKey;

	private String Password;

	private String oldPassword;

	private String userId;

	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getResetKey() {
		return ResetKey;
	}

	public void setResetKey(String resetKey) {
		ResetKey = resetKey;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "UserResetPasswordDTO [emailId=" + emailId + ", ResetKey=" + ResetKey + ", Password=" + Password
				+ ", oldPassword=" + oldPassword + ", userId=" + userId + ", userName=" + userName + "]";
	}
	

}
