package com.example.online_shopping.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblstatustypes_m")
//@Audited
@JsonFilter("statusTypesMasterFilter")
public class TblStatusTypes extends AbstractAuditingEntity {

	private static final long serialVersionUID = 1L;

	@Id
//	@GenericGenerator(name = "tblStatusTypes_string_id_generator", strategy = "com.wdsi.microservice.bidding.hbm.generator.DeafultTblStatusTypeIDGenerator", parameters = {
//			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DeafultTblStatusTypeIDGenerator.defaultsSequencePrefix),
//			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DeafultTblStatusTypeIDGenerator.defaultSsequenceIncrement) })
//	@GeneratedValue(generator = "tblStatusTypes_string_id_generator")
	@Column(name = "id")
	private String id;

	@Column(name = "statuscode")
	private String statusCode;

	@Column(name = "statusdesc")
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
		return "TblStatusTypes [id=" + id + ", statusCode=" + statusCode + ", statusDesc=" + statusDesc + "]";
	}

	public TblStatusTypes(String id, String statusCode, String statusDesc) {
		super();
		this.id = id;
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}

	public TblStatusTypes() {
		// TODO Auto-generated constructor stub
	}

}
