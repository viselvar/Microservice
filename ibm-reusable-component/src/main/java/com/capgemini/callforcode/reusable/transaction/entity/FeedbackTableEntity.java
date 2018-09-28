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
@Table(name = "FEEDBACK_TABLE")
public class FeedbackTableEntity extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6452187074718087439L;

	@Id
	@Column(name = "FEEDBACK_ID")
	private long feedbackId;

	@Column(name = "SUBMITTER_NAME")
	private String submitterName;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FEEDBACK_MESSAGE")
	private String feedbackMessage;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CAMP_ID", referencedColumnName = "CAMP_ID")
	@JsonIgnore
	private CampDetailsEntity campDetailsEntity;

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getSubmitterName() {
		return submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
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

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public CampDetailsEntity getCampDetailsEntity() {
		return campDetailsEntity;
	}

	public void setCampDetailsEntity(CampDetailsEntity campDetailsEntity) {
		this.campDetailsEntity = campDetailsEntity;
	}
	
}
