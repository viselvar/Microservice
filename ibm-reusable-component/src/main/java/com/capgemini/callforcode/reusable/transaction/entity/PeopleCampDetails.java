package com.capgemini.callforcode.reusable.transaction.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PEOPLE_CAMP_DETAILS")
public class PeopleCampDetails extends BasicEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7700450307044780625L;

	@Id
	@Column(name = "PEOPLE_CAMP_ID")
	private long peopleCampId;

	@Column(name = "AFFECTED_NAME")
	private String affectedName;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "SEVERITY")
	private String severity;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CAMP_ID", referencedColumnName = "CAMP_ID")
	@JsonIgnore
	private CampDetailsEntity campDetailsEntity;

	public long getPeopleCampId() {
		return peopleCampId;
	}

	public void setPeopleCampId(long peopleCampId) {
		this.peopleCampId = peopleCampId;
	}

	public String getAffectedName() {
		return affectedName;
	}

	public void setAffectedName(String affectedName) {
		this.affectedName = affectedName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public CampDetailsEntity getCampDetailsEntity() {
		return campDetailsEntity;
	}

	public void setCampDetailsEntity(CampDetailsEntity campDetailsEntity) {
		this.campDetailsEntity = campDetailsEntity;
	}
	
}
