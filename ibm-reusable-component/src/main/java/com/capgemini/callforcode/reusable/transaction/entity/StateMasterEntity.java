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
@Table(name = "STATE_MASTER")
public class StateMasterEntity extends BasicEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7566254084509339033L;


	@Id
    @Column(name = "STATE_ID")
    private long stateId;

   
    @Column(name = "STATE_NAME")
    private String stateName;

    @Column(name = "STATE_DESCRIPTION")
    private String stateDescription;
    
    @OneToMany(mappedBy = "stateMasterEntity", cascade = CascadeType.ALL)
    private List<AssociationMasterEntity> associationMasterEntityList;

    
    @OneToMany(mappedBy = "stateMasterEntity", cascade = CascadeType.ALL)
    private List<DistrictMasterEntity> districtMasterEntityList;
    
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @JsonIgnore
    private CountryMasterEntity countryMasterEntity;

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateDescription() {
		return stateDescription;
	}

	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	public CountryMasterEntity getCountryMasterEntity() {
		return countryMasterEntity;
	}

	public void setCountryMasterEntity(CountryMasterEntity countryMasterEntity) {
		this.countryMasterEntity = countryMasterEntity;
	}
    
}
