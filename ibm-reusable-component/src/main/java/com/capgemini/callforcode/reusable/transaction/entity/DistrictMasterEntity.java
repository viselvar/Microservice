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
@Table(name = "DISTRICT_MASTER")
public class DistrictMasterEntity extends BasicEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 2461196986314769258L;

	@Id
	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "DISTRICT_NAME")
	private String districtName;

	@Column(name = "DISTRICT_DESCRIPTION")
	private String districtDescription;

	@ManyToOne
	@JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
	@JsonIgnore
	private StateMasterEntity stateMasterEntity;

	@OneToMany(mappedBy = "districtMasterEntity", cascade = CascadeType.ALL)
	private List<LocationMasterEntity> locationMasterEntityList;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictDescription() {
		return districtDescription;
	}

	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}

	public StateMasterEntity getStateMasterEntity() {
		return stateMasterEntity;
	}

	public void setStateMasterEntity(StateMasterEntity stateMasterEntity) {
		this.stateMasterEntity = stateMasterEntity;
	}

	public List<LocationMasterEntity> getLocationMasterEntityList() {
		return locationMasterEntityList;
	}

	public void setLocationMasterEntityList(List<LocationMasterEntity> locationMasterEntityList) {
		this.locationMasterEntityList = locationMasterEntityList;
	}

}
