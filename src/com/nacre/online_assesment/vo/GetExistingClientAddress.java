package com.nacre.online_assesment.vo;

import java.io.Serializable;

/**
 * @author Saurabh Suman & Sonali Chavan
 * VO for get client contact details from database.
 */

public class GetExistingClientAddress implements Serializable {

	private Integer clientId;
	private String ClientName;
	private String ContactPresonName;
	private String ContactPresonMobileNO;
	private String ContactPresonNameEmail;
	private String Location;
	private String Pincode;
	private String Country;
	private String City;
	private String State;
	private Integer addressId;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	
	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	/**
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
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
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return ClientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	/**
	 * @return the contactPresonName
	 */
	public String getContactPresonName() {
		return ContactPresonName;
	}
	/**
	 * @param contactPresonName the contactPresonName to set
	 */
	public void setContactPresonName(String contactPresonName) {
		ContactPresonName = contactPresonName;
	}
	/**
	 * @return the contactPresonMobileNO
	 */
	public String getContactPresonMobileNO() {
		return ContactPresonMobileNO;
	}
	/**
	 * @param contactPresonMobileNO the contactPresonMobileNO to set
	 */
	public void setContactPresonMobileNO(String contactPresonMobileNO) {
		ContactPresonMobileNO = contactPresonMobileNO;
	}
	/**
	 * @return the contactPresonNameEmail
	 */
	public String getContactPresonNameEmail() {
		return ContactPresonNameEmail;
	}
	/**
	 * @param contactPresonNameEmail the contactPresonNameEmail to set
	 */
	public void setContactPresonNameEmail(String contactPresonNameEmail) {
		ContactPresonNameEmail = contactPresonNameEmail;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return Location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		Location = location;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return Pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		Country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetExistingClientAddress [clientId=" + clientId + ", ClientName=" + ClientName + ", ContactPresonName="
				+ ContactPresonName + ", ContactPresonMobileNO=" + ContactPresonMobileNO + ", ContactPresonNameEmail="
				+ ContactPresonNameEmail + ", Location=" + Location + ", Pincode=" + Pincode + ", Country=" + Country
				+ ", City=" + City + ", State=" + State + ", addressId=" + addressId + ", countryId=" + countryId
				+ ", stateId=" + stateId + ", cityId=" + cityId + "]";
	}
	

}
