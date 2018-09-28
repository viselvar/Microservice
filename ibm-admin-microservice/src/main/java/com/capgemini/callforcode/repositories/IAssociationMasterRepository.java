package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.AssociationMasterEntity;

@Repository
public interface IAssociationMasterRepository extends PagingAndSortingRepository<AssociationMasterEntity, Long> {

	@Query("select association from AssociationMasterEntity association where association.status='Active' ")
	public List<AssociationMasterEntity> getAssociation();

	@Query("Select s from AssociationMasterEntity s where s.stateMasterEntity.stateId=?1")
	public List<AssociationMasterEntity> getAssociationNames(long stateId);

	@Query("Select a from AssociationMasterEntity a where a.associationName=?1")
	public AssociationMasterEntity getAssociationName(String associationName);

}