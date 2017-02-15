package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class ClientManagementEditContactBean implements Serializable {

	/**
	 * @author Saurabh Suman & Sonali Chavan
	 *  Bean for making obj of client contact details taken by user during editing.
	 */
	private static final long serialVersionUID = 1L;
	
	int addressId;
	Integer pincode;
    String conatact_person_name;
    String contact_person_mobile_no;
    String contact_person_Email;
    Integer cityId;
    String location;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int address_Id) {
		this.addressId = address_Id;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getConatact_person_name() {
		return conatact_person_name;
	}
	public void setConatact_person_name(String conatact_person_name) {
		this.conatact_person_name = conatact_person_name;
	}
	public String getContact_person_mobile_no() {
		return contact_person_mobile_no;
	}
	public void setContact_person_mobile_no(String contact_person_mobile_no) {
		this.contact_person_mobile_no = contact_person_mobile_no;
	}
	public String getContact_person_Email() {
		return contact_person_Email;
	}
	public void setContact_person_Email(String contact_person_mobile_Email) {
		this.contact_person_Email = contact_person_mobile_Email;
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
	@Override
	public String toString() {
		return "ClientManagementEditContactBean [addressId=" + addressId + ", pincode=" + pincode
				+ ", conatact_person_name=" + conatact_person_name + ", contact_person_mobile_no="
				+ contact_person_mobile_no + ", contact_person_mobile_Email=" + contact_person_Email
				+ ", cityId=" + cityId + ", location=" + location + "]";
	}
	
    

}
