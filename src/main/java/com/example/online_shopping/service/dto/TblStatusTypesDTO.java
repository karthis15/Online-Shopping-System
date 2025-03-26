package com.example.online_shopping.service.dto;

import java.io.Serializable;

public class TblStatusTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String statusCode;

	private String statusDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TblStatusTypesDTO [id=" + id + ", statusCode=" + statusCode + ", statusDesc=" + statusDesc + "]";
	}

	public TblStatusTypesDTO(String id, String statusCode, String statusDesc) {
		super();
		this.id = id;
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}
	
	

}
