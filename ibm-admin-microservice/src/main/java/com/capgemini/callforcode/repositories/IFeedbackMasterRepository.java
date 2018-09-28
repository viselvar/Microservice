package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.hackathon.ref.entity.FeedbackTableEntity;

public interface IFeedbackMasterRepository extends PagingAndSortingRepository<FeedbackTableEntity, Long> {

	@Query("Select s from FeedbackTableEntity s")
	public List<FeedbackTableEntity> getFormDetails();

}