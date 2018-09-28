package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.AssociationMasterDto;

public interface IAssociationMasterService {

	public List<AssociationMasterDto> associationDetails();

	public List<AssociationMasterDto> getAssociationNames(long stateId);

	public String updateAssociationStatus(String associationName, String status);
}