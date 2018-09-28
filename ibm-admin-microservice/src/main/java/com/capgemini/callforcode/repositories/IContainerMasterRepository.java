package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.ContainerMasterEntity;


@Repository
public interface IContainerMasterRepository extends PagingAndSortingRepository<ContainerMasterEntity, Long> {


	 
    @Query( "SELECT c FROM ContainerMasterEntity c")
    public List<ContainerMasterEntity> getAllContainers();
}
