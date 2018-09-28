package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.StateMasterDto;
import com.capgemini.callforcode.repositories.IStateMasterRepository;
import com.cg.hackathon.ref.entity.StateMasterEntity;

@Service
public class StateMasterServiceImpl implements IStateMasterService {

	@Autowired
	IStateMasterRepository iStateMasterRepository;
	
	@Override
	public List<StateMasterDto> getStates(long countryId) 
	{
		List<StateMasterDto> stateDtoList = new ArrayList<>();
		List<StateMasterEntity> stateEntityList = iStateMasterRepository.getStates(countryId);
		for(StateMasterEntity stateList : stateEntityList) {
			StateMasterDto stateMasterDto = new StateMasterDto();
			stateMasterDto.setStateId(stateList.getStateId());
		    stateMasterDto.setStateName(stateList.getStateName());
		    stateDtoList.add(stateMasterDto);
		}
		return stateDtoList;
	}
	
	@Override
	public List<StateMasterDto> getStateNames() {
		List<StateMasterDto> statemasterdto = new ArrayList<>();
		List<StateMasterEntity> stateEntitylist = iStateMasterRepository.getStateNames();
		for(StateMasterEntity StateList : stateEntitylist )
		{
			
		StateMasterDto statemaster=new StateMasterDto();
		statemaster.setStateId(StateList.getStateId());
		statemaster.setStateName(StateList.getStateName());
		statemaster.setStateDescription(StateList.getStateDescription());
		statemasterdto.add(statemaster);
		}
		return statemasterdto;
	}
	
}