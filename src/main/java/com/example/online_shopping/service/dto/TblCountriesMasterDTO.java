package com.example.online_shopping.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CountriesMaster entity.
 */
public class TblCountriesMasterDTO implements Serializable {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = -6385978433204898550L;

	private String id;
	private String countryName;
	private String currency;
	private String alpha2;
	private int countrycode;
	private String region;
	private String subregion;
	private String timeZone;
	private String currencyCode;
	private String callingCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAlpha2() {
		return alpha2;
	}
	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCallingCode() {
		return callingCode;
	}
	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TblCountriesMasterDTO [id=" + id + ", countryName=" + countryName + ", currency=" + currency
				+ ", alpha2=" + alpha2 + ", countrycode=" + countrycode + ", region=" + region + ", subregion="
				+ subregion + ", timeZone=" + timeZone + ", currencyCode=" + currencyCode + ", callingCode="
				+ callingCode + "]";
	}
	public TblCountriesMasterDTO(String id, String countryName, String currency, String alpha2, int countrycode,
			String region, String subregion, String timeZone, String currencyCode, String callingCode) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.currency = currency;
		this.alpha2 = alpha2;
		this.countrycode = countrycode;
		this.region = region;
		this.subregion = subregion;
		this.timeZone = timeZone;
		this.currencyCode = currencyCode;
		this.callingCode = callingCode;
	}

	
}
