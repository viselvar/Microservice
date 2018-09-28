package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.hackathon.ref.entity.AffectedRegionsEntity;



public interface IAffectedRegionsRepository extends PagingAndSortingRepository<AffectedRegionsEntity, Long>{
	
	@Query("Select s from AffectedRegionsEntity s where s.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateId=?1")
	
	List<AffectedRegionsEntity> getAffectedRegionsNames(String stateName);  
	

	@Query("Select s from AffectedRegionsEntity s where s.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateId=?1")
	
	List<AffectedRegionsEntity> getAffectedRegionsNames(long stateId);  

}