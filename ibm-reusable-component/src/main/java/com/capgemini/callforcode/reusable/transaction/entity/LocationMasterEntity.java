package com.capgemini.callforcode.reusable.transaction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LOCATION_MASTER")
public class LocationMasterEntity extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2257997280488121216L;

	@Id
	@Column(name = "LOCATION_ID")
	private long locationId;

	@Column(name = "LOCATION_NAME")
	private String locationName;

	@Column(name = "LOCATION_DESC")
	private String locationDesc;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	@JsonIgnore
	private DistrictMasterEntity districtMasterEntity;

	@OneToMany(mappedBy = "locationMasterEntity", cascade = CascadeType.ALL)
	private List<CampDetailsEntity> campDetailsEntityList;

	public DistrictMasterEntity getDistrictMasterEntity() {
		return districtMasterEntity;
	}

	public void setDistrictMasterEntity(DistrictMasterEntity districtMasterEntity) {
		this.districtMasterEntity = districtMasterEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getLocationId() {
		return locationId;
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

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public List<CampDetailsEntity> getCampDetailsEntityList() {
		return campDetailsEntityList;
	}

	public void setCampDetailsEntityList(List<CampDetailsEntity> campDetailsEntityList) {
		this.campDetailsEntityList = campDetailsEntityList;
	}

}
