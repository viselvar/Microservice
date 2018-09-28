package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.CountryMasterEntity;

@Repository
public interface ICountryMasterRepository extends PagingAndSortingRepository<CountryMasterEntity, Long> {

	 @Query("Select s from CountryMasterEntity s")
	   public List<CountryMasterEntity> getCountries(); 
}