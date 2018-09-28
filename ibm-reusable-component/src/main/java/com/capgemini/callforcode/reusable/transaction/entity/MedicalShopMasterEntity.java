package com.capgemini.callforcode.reusable.transaction.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "MEDICAL_SHOP_MASTER")
	public class MedicalShopMasterEntity extends BasicEntity{

		

		/**
		 * 
		 */
		private static final long serialVersionUID = 3910498410636496878L;

		@Id
		@Column(name = "MEDICAL_SHOP_ID")
		private long medicalShopId;
		
		@Column(name="MEDICAL_SHOP_DESCRIPTION")
		private String medicalShopDesc;
		
		@Column(name="LATITUDE")
		private String latitude;
		
		@Column(name="LONGITUDE")
		private String longitude;

		public long getMedicalShopId() {
			return medicalShopId;
		}

		public void setMedicalShopId(long medicalShopId) {
			this.medicalShopId = medicalShopId;
		}

		public String getMedicalShopDesc() {
			return medicalShopDesc;
		}

		public void setMedicalShopDesc(String medicalShopDesc) {
			this.medicalShopDesc = medicalShopDesc;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		
		
	}
