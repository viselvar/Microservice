package com.capgemini.callforcode.reusable.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SUPPLIES_DETAILS")
public class SuppliesDetailsEntity extends BasicEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5903047905607458373L;

	@Id
	@Column(name = "SUPPLIES_DETAILS_ID")
	private long suppliesDetailsId;

	@Column(name = "SUPPLY_TYPE")
	private String supplyType;

	@Column(name = "COUNT")
	private long count;

	@Column(name = "THRESHOLD")
	private long threshold;

	@ManyToOne
	@JoinColumn(name = "CAMP_ID", referencedColumnName = "CAMP_ID")
	@JsonIgnore
	private CampDetailsEntity campDetailsEntity;

	public long getSuppliesDetailsId() {
		return suppliesDetailsId;
	}

	public void setSuppliesDetailsId(long suppliesDetailsId) {
		this.suppliesDetailsId = suppliesDetailsId;
	}

	public String getSupplyType() {
		return supplyType;
	}

	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getThreshold() {
		return threshold;
	}

	public void setThreshold(long threshold) {
		this.threshold = threshold;
	}

	public CampDetailsEntity getCampDetailsEntity() {
		return campDetailsEntity;
	}

	public void setCampDetailsEntity(CampDetailsEntity campDetailsEntity) {
		this.campDetailsEntity = campDetailsEntity;
	}

}
