	package com.capgemini.callforcode.reusable.transaction.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "DOCTOR_INTERN_DETAILS")
	public class DoctorInternDetailsEntity extends BasicEntity{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "DOCTOR_INTERN_ID")
		private long doctorInternId;
		
		@Column(name = "DOCTOR_INTERN_NAME")
		private String doctorInternName;

		@Column(name = "CONTACT_NO")
		private long contactNo;
		
		@Column(name="ROLE")
		private String role;
		
		@Column(name="EMAIL_ID")
		private String emailId;

		public long getDoctorInternId() {
			return doctorInternId;
		}

		public void setDoctorInternId(long doctorInternId) {
			this.doctorInternId = doctorInternId;
		}

		public String getDoctorInternName() {
			return doctorInternName;
		}

		public void setDoctorInternName(String doctorInternName) {
			this.doctorInternName = doctorInternName;
		}

		public long getContactNo() {
			return contactNo;
		}

		public void setContactNo(long contactNo) {
			this.contactNo = contactNo;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		

	}

















