package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.AffectedRegionsDto;

public interface IAffectedRegionsMasterService {

	List<AffectedRegionsDto> getAffectedRegionsNamesByName(String stateName);

	List<AffectedRegionsDto> getAffectedRegionsNames(long stateId);

}