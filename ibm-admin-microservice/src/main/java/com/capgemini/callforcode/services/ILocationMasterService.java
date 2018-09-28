package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.LocationMasterDto;

public interface ILocationMasterService {
	public List<LocationMasterDto> getLocationNames();

}