package com.example.online_shopping.service.dto;

import java.io.Serializable;
import java.time.Instant;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String login;

	private Boolean isActive = true;

	private String email;

	private String userName;

	private String password;

	private String mobileNumber;

	private String countryId;;
	private String isOnline;

	private Instant loginInOutTime;

	private String company;

	private Double hometownLatitude;

	private Double hometownLongitude;

	private String hometownZipCode;

	private String otpResetKey;

	private String profileImage;

	private Double profilePercentage;

	private Double profilePercentageStage;

	private Instant dateOfBirth;

	private String address;

	private String city;

	private String state;

	private String pincode;

	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public Instant getLoginInOutTime() {
		return loginInOutTime;
	}

	public void setLoginInOutTime(Instant loginInOutTime) {
		this.loginInOutTime = loginInOutTime;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getHometownLatitude() {
		return hometownLatitude;
	}

	public void setHometownLatitude(Double hometownLatitude) {
		this.hometownLatitude = hometownLatitude;
	}

	public Double getHometownLongitude() {
		return hometownLongitude;
	}

	public void setHometownLongitude(Double hometownLongitude) {
		this.hometownLongitude = hometownLongitude;
	}

	public String getHometownZipCode() {
		return hometownZipCode;
	}

	public void setHometownZipCode(String hometownZipCode) {
		this.hometownZipCode = hometownZipCode;
	}

	public String getOtpResetKey() {
		return otpResetKey;
	}

	public void setOtpResetKey(String otpResetKey) {
		this.otpResetKey = otpResetKey;
	}

	public Double getProfilePercentage() {
		return profilePercentage;
	}

	public void setProfilePercentage(Double profilePercentage) {
		this.profilePercentage = profilePercentage;
	}

	public Double getProfilePercentageStage() {
		return profilePercentageStage;
	}

	public void setProfilePercentageStage(Double profilePercentageStage) {
		this.profilePercentageStage = profilePercentageStage;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", login=" + login + ", isActive=" + isActive + ", email=" + email + ", userName="
				+ userName + ", password=" + password + ", mobileNumber=" + mobileNumber + ", countryId=" + countryId
				+ ", isOnline=" + isOnline + ", loginInOutTime=" + loginInOutTime + ", company=" + company
				+ ", hometownLatitude=" + hometownLatitude + ", hometownLongitude=" + hometownLongitude
				+ ", hometownZipCode=" + hometownZipCode + ", otpResetKey=" + otpResetKey + ", profileImage="
				+ profileImage + ", profilePercentage=" + profilePercentage + ", profilePercentageStage="
				+ profilePercentageStage + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", role=" + role + "]";
	}
	
	

	public UserDTO(String id, String login, Boolean isActive, String email, String userName, String password,
			String mobileNumber, String countryId, String isOnline, Instant loginInOutTime, String company,
			Double hometownLatitude, Double hometownLongitude, String hometownZipCode, String otpResetKey,
			String profileImage, Double profilePercentage, Double profilePercentageStage, Instant dateOfBirth,
			String address, String city, String state, String pincode, String role) {
		super();
		this.id = id;
		this.login = login;
		this.isActive = isActive;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.countryId = countryId;
		this.isOnline = isOnline;
		this.loginInOutTime = loginInOutTime;
		this.company = company;
		this.hometownLatitude = hometownLatitude;
		this.hometownLongitude = hometownLongitude;
		this.hometownZipCode = hometownZipCode;
		this.otpResetKey = otpResetKey;
		this.profileImage = profileImage;
		this.profilePercentage = profilePercentage;
		this.profilePercentageStage = profilePercentageStage;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role = role;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String login, String email, String userName, String password) {
		super();
		this.login = login;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

}
