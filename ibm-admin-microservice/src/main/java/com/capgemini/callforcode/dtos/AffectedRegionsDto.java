package com.capgemini.callforcode.dtos;

public class AffectedRegionsDto {
	private long affectedRegionId;
	private String affectedIntensity;
	private long location_id;
	private String location_name;

	public long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(long location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public long getAffectedRegionId() {
		return affectedRegionId;
	}

	public void setAffectedRegionId(long affectedRegionId) {
		this.affectedRegionId = affectedRegionId;
	}

	public String getAffectedIntensity() {
		return affectedIntensity;
	}

	public void setAffectedIntensity(String affectedIntensity) {
		this.affectedIntensity = affectedIntensity;
	}

}
