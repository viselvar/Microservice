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
@Table(name = "MEDICAL_SUPPORT")
public class MedicalSupportEntity extends BasicEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6908561137032202057L;

	@Id
	@Column(name = "MEDICAL_SUPPORT_ID")
	private long medicalSupportId;
	
	@Column(name = "DOCTOR_COUNT")
	private long doctorCount;
	

	@Column(name = "INTERN_COUNT")
	private long internCount;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CAMP_ID", referencedColumnName = "CAMP_ID")
	@JsonIgnore
	private CampDetailsEntity campDetailsEntity;

	public long getMedicalSupportId() {
		return medicalSupportId;
	}

	public void setMedicalSupportId(long medicalSupportId) {
		this.medicalSupportId = medicalSupportId;
	}

	public long getDoctorCount() {
		return doctorCount;
	}

	public void setDoctorCount(long doctorCount) {
		this.doctorCount = doctorCount;
	}

	public long getInternCount() {
		return internCount;
	}

	public void setInternCount(long internCount) {
		this.internCount = internCount;
	}

	public CampDetailsEntity getCampDetailsEntity() {
		return campDetailsEntity;
	}

	public void setCampDetailsEntity(CampDetailsEntity campDetailsEntity) {
		this.campDetailsEntity = campDetailsEntity;
	}

}
