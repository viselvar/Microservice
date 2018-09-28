
package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.StateMasterEntity;

@Repository
public interface IStateMasterRepository extends PagingAndSortingRepository<StateMasterEntity, Long> {

	 @Query("Select s from StateMasterEntity s where s.countryMasterEntity.countryId=?1")
	   public List<StateMasterEntity> getStates(long countryId); 
	 

	    @Query("Select s from StateMasterEntity s" )
	    List<StateMasterEntity> getStateNames();  
}
