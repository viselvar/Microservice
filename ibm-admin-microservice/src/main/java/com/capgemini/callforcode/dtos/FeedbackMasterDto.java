package com.capgemini.callforcode.dtos;

public class FeedbackMasterDto {

	private String campName;
	private String address;
	private long feedbackId;
	private String submitterName;
	private String contactNumber;
	private String emailId;
	private String feedbackMessage;
	private String createdBy;
	private String updatedBy;
	private char activeflag;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public char getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(char activeflag) {
		this.activeflag = activeflag;
	}

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

}