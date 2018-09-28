package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.AssociationMasterDto;
import com.capgemini.callforcode.repositories.IAssociationMasterRepository;
import com.cg.hackathon.ref.entity.AssociationMasterEntity;

@Service
public class AssociationMasterServiceImpl implements IAssociationMasterService {
	
	Logger logger = LoggerFactory.getLogger(AssociationMasterServiceImpl.class);
	
	@Autowired
	IAssociationMasterRepository iAssociationMasterRepository;

	@Override
	public List<AssociationMasterDto> associationDetails() {
		List<AssociationMasterDto> associationDtoList = new ArrayList<>();
		List<AssociationMasterEntity> associationEntityList = iAssociationMasterRepository.getAssociation();
		for (AssociationMasterEntity associationList : associationEntityList) {
			AssociationMasterDto associationMasterDto = new AssociationMasterDto();
			// associationMasterDto.setAssociationId(associationList.getAssociationId());
			associationMasterDto.setAssociationName(associationList.getAssociationName());
			/*
			 * associationMasterDto.setAssociationDesc(associationList.
			 * getAssociationDesc());
			 * associationMasterDto.setStateId(associationList.
			 * getStateMasterEntity().getStateId());
			 */
			associationMasterDto.setNgoGo(associationList.getNgoGo());
			/*
			 * associationMasterDto.setStatus(associationList.getStatus());
			 * associationMasterDto.setCreatedBy(associationList.getCreatedBy())
			 * ; associationMasterDto.setCreatedDate(associationList.
			 * getCreatedDate());
			 * associationMasterDto.setUpdatedBy(associationList.getUpdatedBy())
			 * ; associationMasterDto.setUpdatedDate(associationList.
			 * getUpdatedDate());
			 */
			associationDtoList.add(associationMasterDto);
		}
		return associationDtoList;
	}

	@Override
	public List<AssociationMasterDto> getAssociationNames(long stateId) {

		List<AssociationMasterDto> associationDtoList = new ArrayList<>();
		List<AssociationMasterEntity> associationEntityList = iAssociationMasterRepository.getAssociationNames(stateId);
		for (AssociationMasterEntity associationList : associationEntityList) {
			AssociationMasterDto associationMasterDto = new AssociationMasterDto();
			associationMasterDto.setAssociationName(associationList.getAssociationName());
			associationDtoList.add(associationMasterDto);
		}
		return associationDtoList;
	}

	@Override
	public String updateAssociationStatus(String associationName, String status) {
		String result = null;
		try {
			AssociationMasterEntity aName1 = iAssociationMasterRepository.getAssociationName(associationName);
			if (aName1 != null) {
				aName1.setStatus(status);
				iAssociationMasterRepository.save(aName1);
				result = "inserted";
			} else {
				result = "no data found for given association name" + associationName;
			}
		} catch (Exception e) {
			logger.error("error in retrieving data", e);
		}

		return result;
	}

}