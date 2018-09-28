package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.MedicalShopDto;
import com.cg.hackathon.ref.entity.MedicalShopMasterEntity;

public interface IMedicalShopService {

	public List<MedicalShopDto> getMedicalDetails();

	List<MedicalShopMasterEntity> getAllMedicalShops();

}
