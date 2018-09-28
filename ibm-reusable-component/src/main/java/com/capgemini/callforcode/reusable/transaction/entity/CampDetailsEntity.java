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
@Table(name = "CAMP_DETAILS")
public class CampDetailsEntity extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3218182688394841242L;

	@Id
	@Column(name = "CAMP_ID")
	private long campId;

	@Column(name = "CAMP_NAME")
	private String campName;

	@Column(name = "ADDRESS")
	private String address;
	
	@ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    @JsonIgnore
    private LocationMasterEntity locationMasterEntity;
 
	@OneToMany(mappedBy = "campDetailsEntity", cascade = CascadeType.ALL)
    private List<CampContainerDetailsEntity> campContainerDetailsEntityList;

	@OneToMany(mappedBy = "campDetailsEntity", cascade = CascadeType.ALL)
    private List<MedicalSupportEntity> medicalSupportEntityList;

	@OneToMany(mappedBy = "campDetailsEntity", cascade = CascadeType.ALL)
    private List<FeedbackTableEntity> feedbackTableEntityList;

	@OneToMany(mappedBy = "campDetailsEntity", cascade = CascadeType.ALL)
    private List<PeopleCampDetails> peopleCampDetailsList;

	@OneToMany(mappedBy = "campDetailsEntity", cascade = CascadeType.ALL)
    private List<SuppliesDetailsEntity> suppliesDetailsEntityList;

	public long getCampId() {
		return campId;
	}

	public void setCampId(long campId) {
		this.campId = campId;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocationMasterEntity getLocationMasterEntity() {
		return locationMasterEntity;
	}

	public void setLocationMasterEntity(LocationMasterEntity locationMasterEntity) {
		this.locationMasterEntity = locationMasterEntity;
	}

	public List<CampContainerDetailsEntity> getCampContainerDetailsEntityList() {
		return campContainerDetailsEntityList;
	}

	public void setCampContainerDetailsEntityList(List<CampContainerDetailsEntity> campContainerDetailsEntityList) {
		this.campContainerDetailsEntityList = campContainerDetailsEntityList;
	}

	public List<MedicalSupportEntity> getMedicalSupportEntityList() {
		return medicalSupportEntityList;
	}

	public void setMedicalSupportEntityList(List<MedicalSupportEntity> medicalSupportEntityList) {
		this.medicalSupportEntityList = medicalSupportEntityList;
	}

	public List<FeedbackTableEntity> getFeedbackTableEntityList() {
		return feedbackTableEntityList;
	}

	public void setFeedbackTableEntityList(List<FeedbackTableEntity> feedbackTableEntityList) {
		this.feedbackTableEntityList = feedbackTableEntityList;
	}

	public List<PeopleCampDetails> getPeopleCampDetailsList() {
		return peopleCampDetailsList;
	}

	public void setPeopleCampDetailsList(List<PeopleCampDetails> peopleCampDetailsList) {
		this.peopleCampDetailsList = peopleCampDetailsList;
	}

	public List<SuppliesDetailsEntity> getSuppliesDetailsEntityList() {
		return suppliesDetailsEntityList;
	}

	public void setSuppliesDetailsEntityList(List<SuppliesDetailsEntity> suppliesDetailsEntityList) {
		this.suppliesDetailsEntityList = suppliesDetailsEntityList;
	}

}
