package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.LocationMasterDto;
import com.capgemini.callforcode.repositories.ILocationMasterRepository;
import com.cg.hackathon.ref.entity.LocationMasterEntity;



	
	
@Service
	public class LocationMasterServiceImpl implements ILocationMasterService {
	@Autowired
	ILocationMasterRepository iLocationMasterRepository;

	@Override
	public List<LocationMasterDto> getLocationNames() {
		List<LocationMasterDto> locationmasterdto = new ArrayList<>();
		List<LocationMasterEntity> locationEntitylist = iLocationMasterRepository.getLocationNames();
		for(LocationMasterEntity LocationList : locationEntitylist ) {

		LocationMasterDto locationmaster=new LocationMasterDto();
		locationmaster.setLocationName(LocationList.getLocationName());
		locationmasterdto.add(locationmaster);
		}
		return locationmasterdto;
	}

}