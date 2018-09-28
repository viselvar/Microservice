package com.capgemini.callforcode.reusable.transaction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryMasterEntity extends BasicEntity{

    /**
     * 
     */
    private static final long serialVersionUID = 8244106367255596220L;

    @Id
    @Column(name = "COUNTRY_ID")
    private long countryId;

   
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "COUNTRY_DESCRIPTION")
    private String countryDescription;

    @OneToMany(mappedBy = "countryMasterEntity", cascade = CascadeType.ALL)
    private List<StateMasterEntity> stateMasterEntityList;

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

   

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

	public List<StateMasterEntity> getStateMasterEntityList() {
		return stateMasterEntityList;
	}

	public void setStateMasterEntityList(List<StateMasterEntity> stateMasterEntityList) {
		this.stateMasterEntityList = stateMasterEntityList;
	}

    
}
