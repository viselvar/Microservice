package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.CampMasterDto;

public interface ICampMasterService {

	public List<CampMasterDto> getCampNames(long locationId);

}