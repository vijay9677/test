package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author vijay kumar p
 * @Description: this class is using getting data from database which stores the
 *               data about company details
 * 
 */
public class ViewJobNotificationBean implements Serializable {

	private String companyName;
	private String clientLogo;
	private String location;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String contatPersonName;
	private String ContactPersonMobileNo;
	private String contactPersonEmail;
	private String companyDescription;
	private String jobDescription;
	private String expecteddate;
	private String assesmentStartDate;
	private String assesmentEndDate;
	private String postedDate;
	private int noofvacancies;
	private String technology;

	/**
	 * 
	 */
	public ViewJobNotificationBean() {
		super();
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the clientLogo
	 */
	public String getClientLogo() {
		return clientLogo;
	}

	/**
	 * @param clientLogo
	 *            the clientLogo to set
	 */
	public void setClientLogo(String clientLogo) {
		this.clientLogo = clientLogo;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
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
	 * @param city
	 *            the city to set
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
	 * @param state
	 *            the state to set
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
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the contatPersonName
	 */
	public String getContatPersonName() {
		return contatPersonName;
	}

	/**
	 * @param contatPersonName
	 *            the contatPersonName to set
	 */
	public void setContatPersonName(String contatPersonName) {
		this.contatPersonName = contatPersonName;
	}

	/**
	 * @return the contactPersonMobileNo
	 */
	public String getContactPersonMobileNo() {
		return ContactPersonMobileNo;
	}

	/**
	 * @param contactPersonMobileNo
	 *            the contactPersonMobileNo to set
	 */
	public void setContactPersonMobileNo(String contactPersonMobileNo) {
		ContactPersonMobileNo = contactPersonMobileNo;
	}

	/**
	 * @return the contactPersonEmail
	 */
	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	/**
	 * @param contactPersonEmail
	 *            the contactPersonEmail to set
	 */
	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	/**
	 * @return the companyDescription
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * @param companyDescription
	 *            the companyDescription to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription
	 *            the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return the expecteddate
	 */
	public String getExpecteddate() {
		return expecteddate;
	}

	/**
	 * @param expecteddate
	 *            the expecteddate to set
	 */
	public void setExpecteddate(String expecteddate) {
		this.expecteddate = expecteddate;
	}

	/**
	 * @return the assesmentStartDate
	 */
	public String getAssesmentStartDate() {
		return assesmentStartDate;
	}

	/**
	 * @param assesmentStartDate
	 *            the assesmentStartDate to set
	 */
	public void setAssesmentStartDate(String assesmentStartDate) {
		this.assesmentStartDate = assesmentStartDate;
	}

	/**
	 * @return the assesmentEndDate
	 */
	public String getAssesmentEndDate() {
		return assesmentEndDate;
	}

	/**
	 * @param assesmentEndDate
	 *            the assesmentEndDate to set
	 */
	public void setAssesmentEndDate(String assesmentEndDate) {
		this.assesmentEndDate = assesmentEndDate;
	}

	/**
	 * @return the postedDate
	 */
	public String getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate
	 *            the postedDate to set
	 */
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	/**
	 * @return the noofvacancies
	 */
	public int getNoofvacancies() {
		return noofvacancies;
	}

	/**
	 * @param noofvacancies
	 *            the noofvacancies to set
	 */
	public void setNoofvacancies(int noofvacancies) {
		this.noofvacancies = noofvacancies;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology
	 *            the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ViewJobNotificationBean [companyName=" + companyName + ", clientLogo=" + clientLogo + ", location="
				+ location + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ ", contatPersonName=" + contatPersonName + ", ContactPersonMobileNo=" + ContactPersonMobileNo
				+ ", contactPersonEmail=" + contactPersonEmail + ", companyDescription=" + companyDescription
				+ ", jobDescription=" + jobDescription + ", expecteddate=" + expecteddate + ", assesmentStartDate="
				+ assesmentStartDate + ", assesmentEndDate=" + assesmentEndDate + ", postedDate=" + postedDate
				+ ", noofvacancies=" + noofvacancies + ", technology=" + technology + "]";
	}

}
