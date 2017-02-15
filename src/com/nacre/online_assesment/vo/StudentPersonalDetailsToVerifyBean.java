package com.nacre.online_assesment.vo;

import java.io.Serializable;


/**
 * @authors Srikanth and krunal B35.

 */
import java.sql.Date;

public class StudentPersonalDetailsToVerifyBean implements Serializable {
	
	@Override
	public String toString() {
		return "StudentPersonalDetailsToVerifyBean [userId=" + userId + ", fname=" + fname + ", lname=" + lname
				+ ", mail=" + mail + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + ", status="
				+ status + ", location=" + location + ", pincode=" + pincode + ", city_id=" + city_id + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", role=" + role + ", countryId=" + countryId
				+ ", stateId=" + stateId + "]";
	}
	private Integer userId;
	private String fname;
	private String lname;
	private String mail;
	private String mobileNo;
	private Integer gender;
	private String image;
	private Date dob;
	private String status;
	private String location;
	private String pincode;
	private Integer city_id;
	
	private String city;
	private String state;
	private String country;
	private String role;
	private Integer countryId;
	private Integer stateId;
	
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param i the gender to set
	 */
	public void setGender(Integer i) {
		this.gender = i;
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
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode2 the pincode to set
	 */
	public void setPincode(String pincode2) {
		this.pincode = pincode2;
	}
	
	/**
	 * @return the city_id
	 */
	public Integer getCity_id() {
		return city_id;
	}
	/**
	 * @param city_id the city_id to set
	 */
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	
	

}
