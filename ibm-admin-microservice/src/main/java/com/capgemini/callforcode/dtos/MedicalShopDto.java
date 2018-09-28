package com.capgemini.callforcode.dtos;

public class MedicalShopDto {
	private long medicalShopId;
	private String medicalShopDesc;
	private String latitude;
	private String longitude;

	public long getMedicalShopId() {
		return medicalShopId;
	}

	public void setMedicalShopId(long medicalShopId) {
		this.medicalShopId = medicalShopId;
	}

	public String getMedicalShopDesc() {
		return medicalShopDesc;
	}

	public void setMedicalShopDesc(String medicalShopDesc) {
		this.medicalShopDesc = medicalShopDesc;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
