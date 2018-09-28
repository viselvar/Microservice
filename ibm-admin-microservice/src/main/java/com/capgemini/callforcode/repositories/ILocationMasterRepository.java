package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.LocationMasterEntity;




@Repository
public interface ILocationMasterRepository extends PagingAndSortingRepository<LocationMasterEntity, Long> {
    
    @Query("Select s from LocationMasterEntity s" )
    List<LocationMasterEntity> getLocationNames();  
    
   
    	
    
}
