package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.CountryMasterDto;
import com.capgemini.callforcode.repositories.ICountryMasterRepository;
import com.cg.hackathon.ref.entity.CountryMasterEntity;

@Service
public class CountryMasterServiceImpl implements ICountryMasterService {

	@Autowired
	ICountryMasterRepository iCountryMasterRepository;

	@Override
	public List<CountryMasterDto> getCountries() {

		List<CountryMasterDto> countryDtoList = new ArrayList<>();
		List<CountryMasterEntity> countryEntityList = iCountryMasterRepository.getCountries();
		for (CountryMasterEntity countryList : countryEntityList) {

			CountryMasterDto countryMasterDto = new CountryMasterDto();
			countryMasterDto.setCountryId(countryList.getCountryId());
			countryMasterDto.setCountryName(countryList.getCountryName());
			countryDtoList.add(countryMasterDto);
		}
		return countryDtoList;
	}

}