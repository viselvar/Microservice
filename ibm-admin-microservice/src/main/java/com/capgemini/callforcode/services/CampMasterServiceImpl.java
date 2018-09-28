package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.CampMasterDto;
import com.capgemini.callforcode.repositories.ICampMasterRepository;
import com.cg.hackathon.ref.entity.CampDetailsEntity;

@Service
public class CampMasterServiceImpl implements ICampMasterService {
	
	@Autowired    
	ICampMasterRepository  iCampMasterRepository;

	@Override
	public List<CampMasterDto> getCampNames(long locationId) {
		List<CampMasterDto> campMasterDtoList = new ArrayList<>();
		List<CampDetailsEntity> campDetailsEntity = iCampMasterRepository.getCampNames(locationId);
		for(CampDetailsEntity campList : campDetailsEntity ) {
			CampMasterDto campMasterDto=new CampMasterDto();
			campMasterDto.setCampName(campList.getCampName());
			campMasterDto.setAddress(campList.getAddress());
			campMasterDtoList.add(campMasterDto);
		}
		return campMasterDtoList;
}
}
