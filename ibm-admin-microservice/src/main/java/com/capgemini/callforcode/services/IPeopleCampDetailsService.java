
package com.capgemini.callforcode.services;

import java.util.List;

import com.capgemini.callforcode.dtos.PeopleCampDetailsDto;
import com.capgemini.callforcode.dtos.SeverityDto;

public interface IPeopleCampDetailsService {
	List<PeopleCampDetailsDto> getAffectedPeopleByNames(String stateName);

	List<PeopleCampDetailsDto> getAffectedPeople(long stateId);

	List<SeverityDto> getseverityDetails(long stateId);

}