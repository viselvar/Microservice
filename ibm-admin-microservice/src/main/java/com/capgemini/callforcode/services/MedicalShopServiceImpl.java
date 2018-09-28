package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.MedicalShopDto;
import com.capgemini.callforcode.repositories.IMedicalShopRepository;
import com.cg.hackathon.ref.entity.MedicalShopMasterEntity;
@Service
public class MedicalShopServiceImpl implements IMedicalShopService{

	@Autowired
	IMedicalShopRepository iMedicalShopRepository;
	
	@Override
	public List<MedicalShopDto> getMedicalDetails() {
		List<MedicalShopMasterEntity> listMedicalShopEntity =iMedicalShopRepository.getMedicalDetails();
		List<MedicalShopDto> medicalShopDtoList =new ArrayList<MedicalShopDto>();
		Iterator<MedicalShopMasterEntity> it=listMedicalShopEntity.iterator();
	while (it.hasNext()) {
		MedicalShopMasterEntity medicalShop = (MedicalShopMasterEntity) it.next();
		MedicalShopDto medicalShopDto =new MedicalShopDto();
		medicalShopDto.setMedicalShopId(medicalShop.getMedicalShopId());
		medicalShopDto.setMedicalShopDesc(medicalShop.getMedicalShopDesc());
		medicalShopDto.setLatitude(medicalShop.getLatitude());
		medicalShopDto.setLongitude(medicalShop.getLongitude());
		medicalShopDtoList.add(medicalShopDto);
	}
		
		return medicalShopDtoList ;
	}

	@Override
	public List<MedicalShopMasterEntity> getAllMedicalShops() {
		return iMedicalShopRepository.getAllMedicalShops();
	}
}
