package com.capgemini.callforcode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.repositories.IContainerMasterRepository;
import com.cg.hackathon.ref.entity.ContainerMasterEntity;
@Service
public class ContainerMasterServiceImpl implements IContainerMasterService{
@Autowired
IContainerMasterRepository iContainerMasterRepository;
	@Override
	public List<ContainerMasterEntity> getAllContainers() {
	
		return iContainerMasterRepository.getAllContainers();
	}

}
