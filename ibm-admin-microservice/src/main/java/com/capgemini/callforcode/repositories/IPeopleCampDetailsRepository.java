
package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.PeopleCampDetails;

@Repository
public interface IPeopleCampDetailsRepository extends PagingAndSortingRepository<PeopleCampDetails, Long> {
	@Query("Select s from PeopleCampDetails s where s.campDetailsEntity.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateName=?1")
	List<PeopleCampDetails> getAffectedPeopleByName(String stateName);
	
	@Query("Select s from PeopleCampDetails s where s.campDetailsEntity.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateId=?1")
	List<PeopleCampDetails> getAffectedPeople(long stateId);

	@Query("select distinct(s.severity) from PeopleCampDetails s where s.campDetailsEntity.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateId=?1")
	List<String> getseverityDetails(long stateId);

	@Query("select count(*) from PeopleCampDetails s where s.campDetailsEntity.locationMasterEntity.districtMasterEntity.stateMasterEntity.stateId=?1 and severity=?2")
	long getcount(long stateId, String severity);
	
}
