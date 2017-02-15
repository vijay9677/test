package com.nacre.online_assesment.form_bean;

import java.io.Serializable;


import java.io.Serializable;

public class AddClientManagementBean implements Serializable{
	
/**
	@author Sonali Chavan This bean is used for making object for all details of client for inserting in database.
	 
	 */
	private static final long serialVersionUID = 1L;
private Integer clientId;
/**
 * @return the clientId
 */
public Integer getClientId() {
	return clientId;
}
/**
 * @param clientId the clientId to set
 */
public void setClientId(Integer clientId) {
	this.clientId = clientId;
}
private String clientName;
private String description;
private Integer companyLevelId;
private String companyImage;
private String contactPersonName;
private String contactPersonMobileNo;
private String contactPersonMail;
private Integer cityId;
private String location;
private String pincode;




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
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getContactPersonName() {
	return contactPersonName;
}
public void setContactPersonName(String contactPersonName) {
	this.contactPersonName = contactPersonName;
}
public String getContactPersonMobileNo() {
	return contactPersonMobileNo;
}
public void setContactPersonMobileNo(String contactPersonMobileNo) {
	this.contactPersonMobileNo = contactPersonMobileNo;
}
public String getContactPersonMail() {
	return contactPersonMail;
}
public void setContactPersonMail(String contactPersonMail) {
	this.contactPersonMail = contactPersonMail;
}
public String getCompanyImage() {
	return companyImage;
}
public void setCompanyImage(String companyImage) {
	this.companyImage = companyImage;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getCompanyLevelId() {
	return companyLevelId;
}
public void setCompanyLevelId(Integer companyLevelId) {
	this.companyLevelId = companyLevelId;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "AddClientManagementBean [clientId=" + clientId + ", clientName="
			+ clientName + ", description=" + description + ", companyLevelId="
			+ companyLevelId + ", companyImage=" + companyImage
			+ ", contactPersonName=" + contactPersonName
			+ ", contactPersonMobileNo=" + contactPersonMobileNo
			+ ", contactPersonMail=" + contactPersonMail + ", cityId=" + cityId
			+ ", location=" + location + ", pincode=" + pincode
			+ ", getClientId()=" + getClientId() + ", getCityId()="
			+ getCityId() + ", getLocation()=" + getLocation()
			+ ", getPincode()=" + getPincode() + ", getContactPersonName()="
			+ getContactPersonName() + ", getContactPersonMobileNo()="
			+ getContactPersonMobileNo() + ", getContactPersonMail()="
			+ getContactPersonMail() + ", getCompanyImage()="
			+ getCompanyImage() + ", getClientName()=" + getClientName()
			+ ", getDescription()=" + getDescription()
			+ ", getCompanyLevelId()=" + getCompanyLevelId() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}


}
