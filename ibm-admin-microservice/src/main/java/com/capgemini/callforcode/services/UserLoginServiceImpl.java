package com.capgemini.callforcode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.callforcode.repositories.IUserRepository;
import com.cg.hackathon.ref.entity.UserMasterEntity;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

	@Autowired
	IUserRepository iUserRepository;

	@Override
	public String login1(String userName) {
		String result = "";
		UserMasterEntity login = iUserRepository.getLoginDetails(userName);
		if (login != null) {
			if (userName.equalsIgnoreCase("Donor") || userName.equalsIgnoreCase("Camp Coordinator")
					|| userName.equalsIgnoreCase("Central Fund Mgmt")) {
				result = "login successfully";
			}

			else {
				result = "this user is valid but cant login";
			}

		} else {
			result = "please enter valid username";
		}
		return result;
	}

	@Override
	public String login(String userName) {
		String result = "";
		UserMasterEntity login = iUserRepository.getLoginDetails(userName);
		/*
		 * if(login.getUserName().equals(userName)){ result =
		 * "login successfully"; }
		 */
		if (login != null && login.getUserName().equals(userName)) {
			result = "login successfully";
		} else {
			result = "please enter valid username";
		}
		return result;
	}

}
