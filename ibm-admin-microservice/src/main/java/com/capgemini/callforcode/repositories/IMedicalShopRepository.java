package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.MedicalShopMasterEntity;

@Repository
public interface IMedicalShopRepository extends PagingAndSortingRepository<MedicalShopMasterEntity, Long>{
	
	 
    @Query( "SELECT c FROM MedicalShopMasterEntity c")
    public List<MedicalShopMasterEntity> getAllMedicalShops();

    @Query("Select m from MedicalShopMasterEntity m where m.activeFlag='Y'")
	public List<MedicalShopMasterEntity> getMedicalDetails();

}
