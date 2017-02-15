package com.nacre.online_assesment.vo;

import java.io.Serializable;

public class GetClientDetailForEditingVo implements Serializable{
	
	private String jobPostingId;
	private String descripition;
	private String expetedDate;
	private String assessmentStartDate;
	private String assessmentEndDare;
	private String postedDate;
	private String noOfVacancies;
	private String clientAddressId;
	private String clientTechnologyId;
	private String location;
	private String city;
	private String state;
	private String country;
	private String pinCode;
	private String clientName;
	private String image;
	private String addressId;
    private String technology;	
    private String clientId;
    
    
	
	
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the jobPostingId
	 */
	public String getJobPostingId() {
		return jobPostingId;
	}
	/**
	 * @param jobPostingId the jobPostingId to set
	 */
	public void setJobPostingId(String jobPostingId) {
		this.jobPostingId = jobPostingId;
	}
	/**
	 * @return the descripition
	 */
	public String getDescripition() {
		return descripition;
	}
	/**
	 * @param descripition the descripition to set
	 */
	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}
	/**
	 * @return the expetedDate
	 */
	public String getExpetedDate() {
		return expetedDate;
	}
	/**
	 * @param expetedDate the expetedDate to set
	 */
	public void setExpetedDate(String expetedDate) {
		this.expetedDate = expetedDate;
	}
	/**
	 * @return the assessmentStartDate
	 */
	public String getAssessmentStartDate() {
		return assessmentStartDate;
	}
	/**
	 * @param assessmentStartDate the assessmentStartDate to set
	 */
	public void setAssessmentStartDate(String assessmentStartDate) {
		this.assessmentStartDate = assessmentStartDate;
	}
	/**
	 * @return the assessmentEndDare
	 */
	public String getAssessmentEndDare() {
		return assessmentEndDare;
	}
	/**
	 * @param assessmentEndDare the assessmentEndDare to set
	 */
	public void setAssessmentEndDare(String assessmentEndDare) {
		this.assessmentEndDare = assessmentEndDare;
	}
	/**
	 * @return the postedDate
	 */
	public String getPostedDate() {
		return postedDate;
	}
	/**
	 * @param postedDate the postedDate to set
	 */
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	/**
	 * @return the noOfVacancies
	 */
	public String getNoOfVacancies() {
		return noOfVacancies;
	}
	/**
	 * @param noOfVacancies the noOfVacancies to set
	 */
	public void setNoOfVacancies(String noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}
	/**
	 * @return the clientAddressId
	 */
	public String getClientAddressId() {
		return clientAddressId;
	}
	/**
	 * @param clientAddressId the clientAddressId to set
	 */
	public void setClientAddressId(String clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
	/**
	 * @return the clientTechnologyId
	 */
	public String getClientTechnologyId() {
		return clientTechnologyId;
	}
	/**
	 * @param clientTechnologyId the clientTechnologyId to set
	 */
	public void setClientTechnologyId(String clientTechnologyId) {
		this.clientTechnologyId = clientTechnologyId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetClientDetailForEditingVo [jobPostingId=" + jobPostingId
				+ ", descripition=" + descripition + ", expetedDate="
				+ expetedDate + ", assessmentStartDate=" + assessmentStartDate
				+ ", assessmentEndDare=" + assessmentEndDare + ", postedDate="
				+ postedDate + ", noOfVacancies=" + noOfVacancies
				+ ", clientAddressId=" + clientAddressId
				+ ", clientTechnologyId=" + clientTechnologyId + ", location="
				+ location + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pinCode=" + pinCode
				+ ", clientName=" + clientName + ", image=" + image
				+ ", addressId=" + addressId + ", technology=" + technology
				+ ", clientId=" + clientId + "]";
	}
	
	
	

}
