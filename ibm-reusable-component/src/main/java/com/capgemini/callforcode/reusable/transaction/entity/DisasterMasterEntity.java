package com.capgemini.callforcode.reusable.transaction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DISASTER_MASTER")
public class DisasterMasterEntity extends BasicEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5954934219210694475L;

	@Id
	@Column(name = "DISASTER_ID")
	private long disasterId;

	@Column(name = "DISASTER_NAME")
	private String disasterName;

	@Column(name = "DISASTER_DESC")
	private String disasterDesc;

	  @OneToMany(mappedBy = "disasterMasterEntity", cascade = CascadeType.ALL)
	    private List<AffectedRegionsEntity> affectedRegionsEntityList;

	public long getDisasterId() {
		return disasterId;
	}

	public void setDisasterId(long disasterId) {
		this.disasterId = disasterId;
	}

	public String getDisasterName() {
		return disasterName;
	}

	public void setDisasterName(String disasterName) {
		this.disasterName = disasterName;
	}

	public String getDisasterDesc() {
		return disasterDesc;
	}

	public void setDisasterDesc(String disasterDesc) {
		this.disasterDesc = disasterDesc;
	}

}
