package com.example.online_shopping.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Audited
@Entity
@Table(name = "tblcountries_m")
@JsonFilter("countriesMasterFilter")
public class TblCountriesMaster extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
//	@GenericGenerator(name = "countriesmaster_string_id_generator", strategy = "com.wdsi.microservice.bidding.hbm.generator.DeafultCountriesMasterIDGenerator", parameters = {
//			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DeafultCountriesMasterIDGenerator.defaultsSequencePrefix),
//			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DeafultCountriesMasterIDGenerator.defaultSsequenceIncrement) })
//	@GeneratedValue(generator = "countriesmaster_string_id_generator") // --alpha_3 code as primary key

	@Column(name = "countryid")
	private String id;

	@Column(name = "countryname")
	private String countryName;

	@Column(name = "currency")
	private String currency;

	@Column(name = "alpha2")
	private String alpha2;

	@Column(name = "countrynumericcode")
	private int countrycode;

	@Column(name = "region")
	private String region;

	@Column(name = "subregion")
	private String subregion;

	@Column(name = "callingcode")
	private String callingCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "timezone")
	private TblTimeZone tblTimeZone;

	@Column(name = "currencysymbol")
	private String currencySymbol;

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

	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public TblTimeZone getTblTimeZone() {
		return tblTimeZone;
	}

	public void setTblTimeZone(TblTimeZone tblTimeZone) {
		this.tblTimeZone = tblTimeZone;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TblCountriesMaster [id=" + id + ", countryName=" + countryName + ", currency=" + currency + ", alpha2="
				+ alpha2 + ", countrycode=" + countrycode + ", region=" + region + ", subregion=" + subregion
				+ ", callingCode=" + callingCode + ", tblTimeZone=" + tblTimeZone + ", currencySymbol=" + currencySymbol
				+ "]";
	}

	public TblCountriesMaster(String id, String countryName, String currency, String alpha2, int countrycode,
			String region, String subregion, String callingCode, TblTimeZone tblTimeZone, String currencySymbol) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.currency = currency;
		this.alpha2 = alpha2;
		this.countrycode = countrycode;
		this.region = region;
		this.subregion = subregion;
		this.callingCode = callingCode;
		this.tblTimeZone = tblTimeZone;
		this.currencySymbol = currencySymbol;
	}

	public TblCountriesMaster() {
		// TODO Auto-generated constructor stub
	}

}
