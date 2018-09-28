package com.capgemini.callforcode.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.dtos.PeopleCampDetailsDto;
import com.capgemini.callforcode.dtos.SeverityDto;
import com.capgemini.callforcode.repositories.IPeopleCampDetailsRepository;
import com.cg.hackathon.ref.entity.CampDetailsEntity;
import com.cg.hackathon.ref.entity.DistrictMasterEntity;
import com.cg.hackathon.ref.entity.LocationMasterEntity;
import com.cg.hackathon.ref.entity.PeopleCampDetails;
import com.cg.hackathon.ref.entity.StateMasterEntity;

@Service
public class PeopleCampDetailsServiceImpl implements IPeopleCampDetailsService {
	@Autowired
	IPeopleCampDetailsRepository iPeopleCampDetailsRepository;

	@Override
	public List<PeopleCampDetailsDto> getAffectedPeopleByNames(String stateName) {

		DistrictMasterEntity districtMasterEntity = new DistrictMasterEntity();
		StateMasterEntity stateMasterEntity = new StateMasterEntity();
		LocationMasterEntity locationMasterEntity = new LocationMasterEntity();
		CampDetailsEntity campDetailsEntity = new CampDetailsEntity();

		List<PeopleCampDetailsDto> peopleCampDetailsDtoList = new ArrayList<>();
		List<PeopleCampDetails> peopleCampDetails = iPeopleCampDetailsRepository.getAffectedPeopleByName(stateName);

		for (PeopleCampDetails peopleCampDetailsList : peopleCampDetails) {
			PeopleCampDetailsDto peopleCampDetailsDto = new PeopleCampDetailsDto();

			stateMasterEntity.setStateId(peopleCampDetailsDto.getPeopleCampId());
			districtMasterEntity.setDistrictId(stateMasterEntity.getStateId());
			locationMasterEntity.setLocationId(districtMasterEntity.getDistrictId());
			campDetailsEntity.setCampId(locationMasterEntity.getLocationId());

			peopleCampDetailsDto.setAffectedName(peopleCampDetailsList.getAffectedName());
			peopleCampDetailsDto.setSeverity(peopleCampDetailsList.getSeverity());
			peopleCampDetailsDto.setPeopleCampId(peopleCampDetailsList.getPeopleCampId());
			peopleCampDetailsDtoList.add(peopleCampDetailsDto);
		}
		return peopleCampDetailsDtoList;

	}

	@Override
	public List<PeopleCampDetailsDto> getAffectedPeople(long stateId) {

		DistrictMasterEntity districtMasterEntity = new DistrictMasterEntity();
		StateMasterEntity stateMasterEntity = new StateMasterEntity();
		LocationMasterEntity locationMasterEntity = new LocationMasterEntity();
		CampDetailsEntity campDetailsEntity = new CampDetailsEntity();

		List<PeopleCampDetailsDto> peopleCampDetailsDtoList = new ArrayList<>();
		List<PeopleCampDetails> peopleCampDetails = iPeopleCampDetailsRepository.getAffectedPeople(stateId);

		for (PeopleCampDetails peopleCampDetailsList : peopleCampDetails) {

			PeopleCampDetailsDto peopleCampDetailsDto = new PeopleCampDetailsDto();
			stateMasterEntity.setStateId(peopleCampDetailsDto.getPeopleCampId());
			districtMasterEntity.setDistrictId(stateMasterEntity.getStateId());
			locationMasterEntity.setLocationId(districtMasterEntity.getDistrictId());
			campDetailsEntity.setCampId(locationMasterEntity.getLocationId());

			peopleCampDetailsDto.setAffectedName(peopleCampDetailsList.getAffectedName());
			peopleCampDetailsDto.setSeverity(peopleCampDetailsList.getSeverity());
			peopleCampDetailsDto.setPeopleCampId(peopleCampDetailsList.getPeopleCampId());

			peopleCampDetailsDtoList.add(peopleCampDetailsDto);
		}

		return peopleCampDetailsDtoList;

	}

	@Override
	public List<SeverityDto> getseverityDetails(long stateId) {
		List<SeverityDto> list = new ArrayList<SeverityDto>();
		List<String> SeverityList = iPeopleCampDetailsRepository.getseverityDetails(stateId);
		Iterator<String> it = SeverityList.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			//System.out.println("severit :" + string);
			long count = iPeopleCampDetailsRepository.getcount(stateId, string);
			//System.out.println("count : " + count);
			SeverityDto severitydto = new SeverityDto();
			severitydto.setSeverityName(string);
			severitydto.setCount(count);
			list.add(severitydto);

		}

		return list;
	}

}
