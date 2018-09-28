package com.capgemini.callforcode.reusable.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AFFECTED_REGIONS")
public class AffectedRegionsEntity extends BasicEntity {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2807163822120669657L;

	@Id
	@Column(name = "AFFECTED_REGION_ID")
	private long affectedRegionId;

	@Column(name = "AFFECTED_INTENSITY")
	private String affectedIntensity;

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
	@JsonIgnore
	private LocationMasterEntity locationMasterEntity;

	@ManyToOne
	@JoinColumn(name = "DISASTER_ID", referencedColumnName = "DISASTER_ID")
	@JsonIgnore
	private DisasterMasterEntity disasterMasterEntity;

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

	public LocationMasterEntity getLocationMasterEntity() {
		return locationMasterEntity;
	}

	public void setLocationMasterEntity(LocationMasterEntity locationMasterEntity) {
		this.locationMasterEntity = locationMasterEntity;
	}

	public DisasterMasterEntity getDisasterMasterEntity() {
		return disasterMasterEntity;
	}

	public void setDisasterMasterEntity(DisasterMasterEntity disasterMasterEntity) {
		this.disasterMasterEntity = disasterMasterEntity;
	}

}
