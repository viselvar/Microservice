package com.capgemini.callforcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cg.hackathon.ref.entity.DisasterMasterEntity;

@Repository
public interface IDisasterMasterRepository extends PagingAndSortingRepository<DisasterMasterEntity, Long>{

    @Query( "SELECT c FROM DisasterMasterEntity c")
    public List<DisasterMasterEntity> getAllDisasters();
}
