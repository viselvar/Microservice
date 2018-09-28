package com.capgemini.callforcode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.repositories.IMedicalShopRepository;
import com.cg.hackathon.ref.entity.MedicalShopMasterEntity;
@Service
public class MedicalShopMasterServiceImpl implements IMedicalShopMasterService{
@Autowired
IMedicalShopRepository iMedicalShopRepository;

	@Override
	public List<MedicalShopMasterEntity> getAllMedicalShops() {
		return iMedicalShopRepository.getAllMedicalShops();
	}

}
