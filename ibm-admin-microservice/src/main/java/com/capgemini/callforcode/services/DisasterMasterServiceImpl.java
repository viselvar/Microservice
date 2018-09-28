package com.capgemini.callforcode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.repositories.IDisasterMasterRepository;
import com.cg.hackathon.ref.entity.DisasterMasterEntity;

@Service
public class DisasterMasterServiceImpl implements IDisasterMasterService {

	@Autowired
	IDisasterMasterRepository iDisasterMasterRepository;
	@Override
	public List<DisasterMasterEntity> getAllDisasters() {
		
		return iDisasterMasterRepository.getAllDisasters();
	}

}
