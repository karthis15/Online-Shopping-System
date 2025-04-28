package com.example.online_shopping.enums;

public enum UserRole {
	ADMIN(1, "ADMIN"), USER(2, "USER"), SALESMAN(3, "SALESMAN"), DELIVERYMAN(4, "DELIVERYMAN"), MANAGER(5, "MANAGER");
	
	private Integer id;

	private String name;

	private UserRole(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
