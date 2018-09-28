package com.capgemini.callforcode.dtos;

public class PeopleCampDetailsDto {
	private long peopleCampId;

	private String affectedName;
	private String severity;

	public String getAffectedName() {
		return affectedName;
	}

	public void setAffectedName(String affectedName) {
		this.affectedName = affectedName;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public long getPeopleCampId() {
		return peopleCampId;
	}

	public void setPeopleCampId(long peopleCampId) {
		this.peopleCampId = peopleCampId;
	}

}