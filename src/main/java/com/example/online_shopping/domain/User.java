package com.example.online_shopping.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Audited
@Table(name = "user_m")
public class User extends AbstractAuditingEntity {
	private static final long serialVersionUID = 1L;

	@Id
//	@GenericGenerator(name = "tbluser_generator", strategy = "com.wdsi.microservice.bidding.hbm.generator.DeafultTblUserIDGenerator", parameters = {
//			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DeafultTblUserIDGenerator.defaultsSequencePrefix),
//			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DeafultTblUserIDGenerator.defaultSsequenceIncrement) })
//	@GeneratedValue(generator = "tbluser_generator")
	@Column(name = "userid")
	private String id;

	@Column(name = "login")
	private String login;

	@Column(name = "isactive")
	private Boolean isActive = true;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;

	@Column(name = "telephonenumber")
	private String telephoneNumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "countryid")
	private TblCountriesMaster countriesMaster;

	// isOnline for Go-online and Go-offline status in mobile
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isonline")
	private TblStatusTypes isOnline;

	@Column(name = "logininouttime")
	private Instant loginInOutTime;

	@Column(name = "company")
	private String company;

	@Column(name = "hometownlatitude")
	private Double hometownLatitude;

	@Column(name = "hometownlongitude")
	private Double hometownLongitude;

	@Column(name = "hometownzipCode")
	private String hometownZipCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profileimagestatus")
	private TblStatusTypes profileImageStatus;

	@Column(name = "otpresetkey")
	private String otpResetKey;

	@Column(name = "profilepercentage")
	private Double profilePercentage;

	@Column(name = "profilepercentagestage")
	private Double profilePercentageStage;

	@Column(name = "dateofbirth")
	private Instant dateOfBirth;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "role")
	private String role;
	
	@Column(name = "failedAttempt")
	private Integer failedAttempt;

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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public TblCountriesMaster getCountriesMaster() {
		return countriesMaster;
	}

	public void setCountriesMaster(TblCountriesMaster countriesMaster) {
		this.countriesMaster = countriesMaster;
	}

	public TblStatusTypes getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(TblStatusTypes isOnline) {
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

	public TblStatusTypes getProfileImageStatus() {
		return profileImageStatus;
	}

	public void setProfileImageStatus(TblStatusTypes profileImageStatus) {
		this.profileImageStatus = profileImageStatus;
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
	

	public Integer getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(Integer failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", isActive=" + isActive + ", email=" + email + ", userName="
				+ userName + ", password=" + password + ", telephoneNumber=" + telephoneNumber + ", countriesMaster="
				+ countriesMaster + ", isOnline=" + isOnline + ", loginInOutTime=" + loginInOutTime + ", company="
				+ company + ", hometownLatitude=" + hometownLatitude + ", hometownLongitude=" + hometownLongitude
				+ ", hometownZipCode=" + hometownZipCode + ", profileImageStatus=" + profileImageStatus
				+ ", otpResetKey=" + otpResetKey + ", profilePercentage=" + profilePercentage
				+ ", profilePercentageStage=" + profilePercentageStage + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", role=" + role + "]";
	}

	public User(String id, String login, Boolean isActive, String email, String userName, String password,
			String telephoneNumber, TblCountriesMaster countriesMaster, TblStatusTypes isOnline, Instant loginInOutTime,
			String company, Double hometownLatitude, Double hometownLongitude, String hometownZipCode,
			TblStatusTypes profileImageStatus, String otpResetKey, Double profilePercentage,
			Double profilePercentageStage, Instant dateOfBirth, String address, String city, String state,
			String pincode, String role) {
		super();
		this.id = id;
		this.login = login;
		this.isActive = isActive;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.telephoneNumber = telephoneNumber;
		this.countriesMaster = countriesMaster;
		this.isOnline = isOnline;
		this.loginInOutTime = loginInOutTime;
		this.company = company;
		this.hometownLatitude = hometownLatitude;
		this.hometownLongitude = hometownLongitude;
		this.hometownZipCode = hometownZipCode;
		this.profileImageStatus = profileImageStatus;
		this.otpResetKey = otpResetKey;
		this.profilePercentage = profilePercentage;
		this.profilePercentageStage = profilePercentageStage;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
