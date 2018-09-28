package com.capgemini.callforcode.reusable.transaction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTAINER_MASTER")
public class ContainerMasterEntity extends BasicEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6971821256054178273L;


	@Id
	@Column(name = "CONTAINER_ID")
	private long containerId;

	
	@Column(name = "CONTAINER_DESC")
	private String containerDesc;
	
	
	@Column(name = "LATTITUDE")
	private String lattitude;
	
	@Column(name = "LONGITUDE")
	private String longitude;

	 
    @OneToMany(mappedBy = "containerMasterEntity", cascade = CascadeType.ALL)
    private List<CampContainerDetailsEntity> campContainerDetailsEntityList;

	public long getContainerId() {
		return containerId;
	}

	public void setContainerId(long containerId) {
		this.containerId = containerId;
	}

	public String getContainerDesc() {
		return containerDesc;
	}

	public void setContainerDesc(String containerDesc) {
		this.containerDesc = containerDesc;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

}
