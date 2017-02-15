package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class EducationlDetilasBean implements Serializable{
	private Integer StreamId;
	private Integer yearOfPass;
	private String Percentage;
	private Integer UnivetsityId;
	private Integer CollegeId;
	private String addUniversityName;
	private String addCollegeName;
	private Integer addressId;
	private Integer cityId;
	private String location;
	private Integer pin;
	private Integer educationType;
	public Integer getStreamId() {
		return StreamId;
	}
	public void setStreamId(Integer streamId) {
		StreamId = streamId;
	}
	public Integer getYearOfPass() {
		return yearOfPass;
	}
	public void setYearOfPass(Integer yearOfPass) {
		this.yearOfPass = yearOfPass;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public Integer getUnivetsityId() {
		return UnivetsityId;
	}
	public void setUnivetsityId(Integer univetsityId) {
		UnivetsityId = univetsityId;
	}
	public Integer getCollegeId() {
		return CollegeId;
	}
	public void setCollegeId(Integer collegeId) {
		CollegeId = collegeId;
	}
	public String getAddUniversityName() {
		return addUniversityName;
	}
	public void setAddUniversityName(String addUniversityName) {
		this.addUniversityName = addUniversityName;
	}
	public String getAddCollegeName() {
		return addCollegeName;
	}
	public void setAddCollegeName(String addCollegeName) {
		this.addCollegeName = addCollegeName;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Integer getEducationType() {
		return educationType;
	}
	public void setEducationType(Integer educationType) {
		this.educationType = educationType;
	}
	@Override
	public String toString() {
		return "EducationlDetilasBean [StreamId=" + StreamId + ", yearOfPass=" + yearOfPass + ", Percentage="
				+ Percentage + ", UnivetsityId=" + UnivetsityId + ", CollegeId=" + CollegeId + ", addUniversityName="
				+ addUniversityName + ", addCollegeName=" + addCollegeName + ", addressId=" + addressId + ", cityId="
				+ cityId + ", location=" + location + ", pin=" + pin + ", educationType=" + educationType + "]";
	}
	
	
	
}
