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
@Table(name = "ASSOCIATION_MASTER")
public class AssociationMasterEntity extends BasicEntity {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486513551937710064L;

	@Id
	@Column(name = "ASSOCIATION_ID")
	private long associationId;

	@Column(name = "ASSOCIATION_NAME")
	private String associationName;

	@Column(name = "ASSOCIATION_DESC")
	private String associationDesc;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
	@JsonIgnore
	private StateMasterEntity stateMasterEntity;

	@Column(name = "NGO_GO")
	private String ngoGo;

	@Column(name = "STATUS")
	private String status;

	public long getAssociationId() {
		return associationId;
	}

	public void setAssociationId(long associationId) {
		this.associationId = associationId;
	}

	public String getAssociationName() {
		return associationName;
	}

	public void setAssociationName(String associationName) {
		this.associationName = associationName;
	}

	public String getAssociationDesc() {
		return associationDesc;
	}

	public void setAssociationDesc(String associationDesc) {
		this.associationDesc = associationDesc;
	}

	public StateMasterEntity getStateMasterEntity() {
		return stateMasterEntity;
	}

	public void setStateMasterEntity(StateMasterEntity stateMasterEntity) {
		this.stateMasterEntity = stateMasterEntity;
	}

	public String getNgoGo() {
		return ngoGo;
	}

	public void setNgoGo(String ngoGo) {
		this.ngoGo = ngoGo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
