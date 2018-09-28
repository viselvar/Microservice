package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.CountryMasterDto;

public interface ICountryMasterService {

	public List<CountryMasterDto> getCountries();

}