package com.capgemini.callforcode.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.UserMasterEntity;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserMasterEntity, Long> {

	 @Query("select u from  UserMasterEntity u where u.userName=?1")
	 UserMasterEntity getLoginDetails(String userName);
}
