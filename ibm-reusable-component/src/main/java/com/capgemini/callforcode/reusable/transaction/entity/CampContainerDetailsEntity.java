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
@Table(name = "CAMP_CONTAINER_DETAILS")
public class CampContainerDetailsEntity extends BasicEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4727938236371216515L;


	@Id
	@Column(name = "CAMP_CONTAINER_ID")
	private long campContainerId;

	
	@Column(name = "CAMP_CONTAINER_DESC")
	private String campContainerDesc;
	

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTAINER_ID", referencedColumnName = "CONTAINER_ID")
	@JsonIgnore
	private ContainerMasterEntity containerMasterEntity;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CAMP_ID", referencedColumnName = "CAMP_ID")
	@JsonIgnore
	private CampDetailsEntity campDetailsEntity;

	public long getCampContainerId() {
		return campContainerId;
	}

	public void setCampContainerId(long campContainerId) {
		this.campContainerId = campContainerId;
	}

	public String getCampContainerDesc() {
		return campContainerDesc;
	}

	public void setCampContainerDesc(String campContainerDesc) {
		this.campContainerDesc = campContainerDesc;
	}

	public ContainerMasterEntity getContainerMasterEntity() {
		return containerMasterEntity;
	}

	public void setContainerMasterEntity(ContainerMasterEntity containerMasterEntity) {
		this.containerMasterEntity = containerMasterEntity;
	}

	public CampDetailsEntity getCampDetailsEntity() {
		return campDetailsEntity;
	}

	public void setCampDetailsEntity(CampDetailsEntity campDetailsEntity) {
		this.campDetailsEntity = campDetailsEntity;
	}
	
	
}
