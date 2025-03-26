package com.example.online_shopping.service.dto;

public class AppUserDTO {

	private Long id;

	private String userName;

	private String password;

	private String role;

	private String tocken;

	public AppUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserDTO(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public AppUserDTO(Long id, String userName, String password, String role, String tocken) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.tocken = tocken;
	}

	public String getTocken() {
		return tocken;
	}

	public void setTocken(String tocken) {
		this.tocken = tocken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", tocken=" + tocken + "]";
	}

}
