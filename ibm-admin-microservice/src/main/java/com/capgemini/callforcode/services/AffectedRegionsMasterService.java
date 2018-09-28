
package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.AffectedRegionsDto;
import com.capgemini.callforcode.repositories.IAffectedRegionsRepository;
import com.cg.hackathon.ref.entity.AffectedRegionsEntity;
import com.cg.hackathon.ref.entity.DistrictMasterEntity;
import com.cg.hackathon.ref.entity.LocationMasterEntity;
import com.cg.hackathon.ref.entity.StateMasterEntity;

@Service
public class AffectedRegionsMasterService implements IAffectedRegionsMasterService {

	@Autowired
	IAffectedRegionsRepository iAffectedRegionsRepository;

	@Override
	public List<AffectedRegionsDto> getAffectedRegionsNamesByName(String stateName) {
		
		List<AffectedRegionsDto> affectedRegionsDtoList = new ArrayList<>();
		List<AffectedRegionsEntity> affectedRegionsEntity = iAffectedRegionsRepository
				.getAffectedRegionsNames(stateName);
		
		DistrictMasterEntity districtMasterEntity = new DistrictMasterEntity();
		StateMasterEntity stateMasterEntity = new StateMasterEntity();
		LocationMasterEntity locationMasterEntity = new LocationMasterEntity();
		
		for (AffectedRegionsEntity affectedRegionsList : affectedRegionsEntity) {
			AffectedRegionsDto affectedRegionsDto = new AffectedRegionsDto();
			
			stateMasterEntity.setStateId(affectedRegionsDto.getAffectedRegionId());
			districtMasterEntity.setDistrictId(stateMasterEntity.getStateId());
			locationMasterEntity.setLocationId(districtMasterEntity.getDistrictId());
			
			affectedRegionsDto.setAffectedRegionId(affectedRegionsList.getAffectedRegionId());
			affectedRegionsDto.setAffectedIntensity(affectedRegionsList.getAffectedIntensity());
			affectedRegionsDto.setLocation_id(affectedRegionsList.getLocationMasterEntity().getLocationId());
			affectedRegionsDto.setLocation_name(affectedRegionsList.getLocationMasterEntity().getLocationName());
			
			affectedRegionsDtoList.add(affectedRegionsDto);
		}
		return affectedRegionsDtoList;
	}

	@Override
	public List<AffectedRegionsDto> getAffectedRegionsNames(long stateId) {
	
		List<AffectedRegionsDto> affectedRegionsDtoList = new ArrayList<>();
		List<AffectedRegionsEntity> affectedRegionsEntity = iAffectedRegionsRepository.getAffectedRegionsNames(stateId);
		
		DistrictMasterEntity districtMasterEntity = new DistrictMasterEntity();
		StateMasterEntity stateMasterEntity = new StateMasterEntity();
		LocationMasterEntity locationMasterEntity = new LocationMasterEntity();
		
		for (AffectedRegionsEntity affectedRegionsList : affectedRegionsEntity) {
			AffectedRegionsDto affectedRegionsDto = new AffectedRegionsDto();
			
			stateMasterEntity.setStateId(affectedRegionsDto.getAffectedRegionId());
			districtMasterEntity.setDistrictId(stateMasterEntity.getStateId());
			locationMasterEntity.setLocationId(districtMasterEntity.getDistrictId());

			affectedRegionsDto.setAffectedRegionId(affectedRegionsList.getAffectedRegionId());
			affectedRegionsDto.setAffectedIntensity(affectedRegionsList.getAffectedIntensity());
			affectedRegionsDto.setLocation_id(affectedRegionsList.getLocationMasterEntity().getLocationId());
			affectedRegionsDto.setLocation_name(affectedRegionsList.getLocationMasterEntity().getLocationName());

			affectedRegionsDtoList.add(affectedRegionsDto);
		}
		return affectedRegionsDtoList;

	}
}