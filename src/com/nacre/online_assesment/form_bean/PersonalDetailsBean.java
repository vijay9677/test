package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PersonalDetailsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer userId;
	private String fname;
	private String lname;
	private String mail;
	private String mobile;
	private String gender;
	private String image;
	private java.util.Date dob;
	private String technology;
	
	private Integer technologyId;
	private String status;
	private Integer pincode;
	private String location;
	private String city;
	private Integer cityId;
	
	private String state;
	private Integer stateId;
	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	private String country;
	
	private Integer countryId;
	

	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String string) {
		this.image = string;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Integer getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PersonalDetailsBean [userId=" + userId + ", fname=" + fname
				+ ", lname=" + lname + ", mail=" + mail + ", mobile=" + mobile
				+ ", gender=" + gender 
				+ ", dob=" + dob + ", technology=" + technology + ", status="
				+ status + ", pincode=" + pincode + ", location=" + location
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
}
