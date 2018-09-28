package com.capgemini.callforcode.dtos;

public class CampMasterDto {
	private long campId;
	private String campName;
	private String Address;

	public long getCampId() {
		return campId;
	}

	public void setCampId(long campId) {
		this.campId = campId;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}