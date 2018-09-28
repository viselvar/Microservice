package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.StateMasterDto;

public interface IStateMasterService {
	
	public List<StateMasterDto> getStates(long countryId);
	
	 List<StateMasterDto> getStateNames();  

}