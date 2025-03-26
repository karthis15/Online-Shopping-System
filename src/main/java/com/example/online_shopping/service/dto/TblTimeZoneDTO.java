package com.example.online_shopping.service.dto;

import java.io.Serializable;

public class TblTimeZoneDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String timeZone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "TblTimeZoneDTO [id=" + id + ", timeZone=" + timeZone + "]";
	}

}
