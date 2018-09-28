package com.capgemini.callforcode.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.callforcode.dtos.AffectedRegionsDto;
import com.capgemini.callforcode.dtos.AssociationMasterDto;
import com.capgemini.callforcode.dtos.CampMasterDto;
import com.capgemini.callforcode.dtos.CountryMasterDto;
import com.capgemini.callforcode.dtos.FeedbackMasterDto;
import com.capgemini.callforcode.dtos.LocationMasterDto;
import com.capgemini.callforcode.dtos.MedicalShopDto;
import com.capgemini.callforcode.dtos.PeopleCampDetailsDto;
import com.capgemini.callforcode.dtos.StateMasterDto;
import com.capgemini.callforcode.services.IAffectedRegionsMasterService;
import com.capgemini.callforcode.services.IAssociationMasterService;
import com.capgemini.callforcode.services.ICampMasterService;
import com.capgemini.callforcode.services.ICountryMasterService;
import com.capgemini.callforcode.services.IFeedbackMasterService;
import com.capgemini.callforcode.services.ILocationMasterService;
import com.capgemini.callforcode.services.IMedicalShopService;
import com.capgemini.callforcode.services.IPeopleCampDetailsService;
import com.capgemini.callforcode.services.IStateMasterService;
import com.capgemini.callforcode.services.IUserLoginService;

@RestController
@RequestMapping("/hackathon")

public class IbmServiceController {

	@Autowired
	IMedicalShopService iMedicalShopService;

	@Autowired
	IAffectedRegionsMasterService iAffectedRegionsService;

	@Autowired
	IPeopleCampDetailsService iPeopleCampDetailsService;

	@Autowired
	IUserLoginService iUserLoginService;

	@Autowired
	ICountryMasterService iCountryMasterService;

	@Autowired
	IStateMasterService iStateMasterService;

	@Autowired
	IAssociationMasterService iAssociationMasterService;

	@Autowired
	IFeedbackMasterService iFeedbackMasterService;

	@Autowired
	ILocationMasterService iLocationMasterService;

	@Autowired
	ICampMasterService iCampMasterService;

	@RequestMapping(value = "/getAssociationDetails", method = RequestMethod.GET, produces = "application/json")
	public List<AssociationMasterDto> associationDetails() throws IOException {
		return iAssociationMasterService.associationDetails();
	}

	/*
	 * @RequestMapping(value = "/login1", method = RequestMethod.GET, produces =
	 * "application/json") public String login(@RequestParam String userName)
	 * throws IOException { return iUserLoginService.login1(userName); }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
	public String login1(@RequestParam String userName) throws IOException {
		return iUserLoginService.login(userName);
	}

	@RequestMapping(value = "/medicalShopDetails", method = RequestMethod.GET, produces = "application/json")
	public List<MedicalShopDto> getMedicalDetails() {
		return iMedicalShopService.getMedicalDetails();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/getCountries", method = RequestMethod.GET, produces = "application/json")
	public List<CountryMasterDto> getCountries() throws SecurityException, IOException, MalformedURLException {
		return iCountryMasterService.getCountries();

	}

	@RequestMapping(value = "/getStates", method = RequestMethod.GET, produces = "application/json")
	public List<StateMasterDto> getStates(long countryId) throws SecurityException, IOException, MalformedURLException {
		List<StateMasterDto> states = new ArrayList<StateMasterDto>();
		states = iStateMasterService.getStates(countryId);
		return states;

	}

	@RequestMapping(value = "/getAssociationNames", method = RequestMethod.GET, produces = "application/json")
	public List<AssociationMasterDto> getAssociationNames(long stateId)
			throws SecurityException, IOException, MalformedURLException {
		return iAssociationMasterService.getAssociationNames(stateId);

	}

	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public String updateAssociationStatus(@RequestParam("associationName") String associationName,
			@RequestParam("status") String status) {
		return iAssociationMasterService.updateAssociationStatus(associationName, status);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/getLocation", method = RequestMethod.GET, produces = "application/json")
	public List<LocationMasterDto> getLocationNames() throws IOException {

		return iLocationMasterService.getLocationNames();
	}

	@RequestMapping(value = "/getCamp", method = RequestMethod.GET, produces = "application/json")
	public List<CampMasterDto> getCampNames(long locationId)
			throws MalformedURLException, SecurityException, IOException {
		List<CampMasterDto> camps = new ArrayList<CampMasterDto>();
		camps = iCampMasterService.getCampNames(locationId);
		return camps;
	}

	@RequestMapping(value = "/insertformdetails", method = RequestMethod.POST, produces = "text/plain")
	public String getFeedbackNames(@RequestBody FeedbackMasterDto feedbackMasterDto) {

		return iFeedbackMasterService.getFeedbackNames(feedbackMasterDto);
	}

	@RequestMapping(value = "/getStatesNames", method = RequestMethod.GET, produces = "application/json")
	public List<StateMasterDto> getStateNames() throws IOException {

		return iStateMasterService.getStateNames();
	}

//	@RequestMapping(value = "/getAffectedRegions", method = RequestMethod.GET, produces = "application/json")
//	List<AffectedRegionsDto> getAffectedRegionsNames(String stateName) throws IOException {
//
//		return iAffectedRegionsService.getAffectedRegionsNamesByName(stateName);
//	}

	@RequestMapping(value = "/getAffectedRegions", method = RequestMethod.GET, produces = "application/json")
	List<AffectedRegionsDto> getAffectedRegionsNames(long stateId) throws IOException {

		return iAffectedRegionsService.getAffectedRegionsNames(stateId);
	}

//	@RequestMapping(value = "/getpeopledetails", method = RequestMethod.GET, produces = "application/json")
//	public List<PeopleCampDetailsDto> getAffectedPeople(String stateName) throws IOException {
//
//		return iPeopleCampDetailsService.getAffectedPeopleByNames(stateName);
//	}

	@RequestMapping(value = "/getpeopledetails", method = RequestMethod.GET, produces = "application/json")
	public List<PeopleCampDetailsDto> getAffectedPeople(long stateId) throws IOException {

		return iPeopleCampDetailsService.getAffectedPeople(stateId);

	}

	/*@RequestMapping(value = "/getContainerDeatils", method = RequestMethod.GET, produces = "application/json")
	public List<CampContainerDto> getContainerNames() throws IOException {

		return iCampContainerDetailsService.getContainerNames();
	}*/
}
