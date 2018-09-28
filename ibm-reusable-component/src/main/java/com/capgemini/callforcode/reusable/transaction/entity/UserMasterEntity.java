package com.capgemini.callforcode.reusable.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")
public class UserMasterEntity extends BasicEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7951681170996714167L;

	@Id
	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "CONTACT_NO")
	private String contactNo;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
