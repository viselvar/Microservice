package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.CampDetailsEntity;



@Repository
public interface ICampMasterRepository extends PagingAndSortingRepository<CampDetailsEntity, Long> {

	
	@Query("Select s from CampDetailsEntity s where s.locationMasterEntity.locationId=?1")
	
	List<CampDetailsEntity> getCampNames(long locationId);
	
	@Query("select campId from CampDetailsEntity  where campName=?1 and address=?2")
	public long  getCampIdDetails(String campName,String address);


	

}