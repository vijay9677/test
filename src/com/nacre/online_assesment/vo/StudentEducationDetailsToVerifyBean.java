package com.nacre.online_assesment.vo;

import java.io.Serializable;
import java.sql.Date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;


/**
 * @authors Srikanth and krunal B35.
 */

public class StudentEducationDetailsToVerifyBean implements Serializable {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	private Integer edu_type_Id;
	private String edu_type;
	private String percent_grade;
	private String year_of_pass;
	private String stream;
	private String college;
	private String univercity;
	private String location;
	private String pincode;
	private String city;
	private String state;
	private String country;
	private Integer userId;
	private Integer streamId;
	private Integer univercityId;
	private Integer cityId;
	private Integer countryId;
	
	
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
	private Integer stateId;
	
	
	/**
	 * @return the edu_type_Id
	 */
	public Integer getEdu_type_Id() {
		return edu_type_Id;
	}
	/**
	 * @param edu_type_Id the edu_type_Id to set
	 */
	public void setEdu_type_Id(Integer edu_type_Id) {
		this.edu_type_Id = edu_type_Id;
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
	 * @return the univercityId
	 */
	public Integer getUnivercityId() {
		return univercityId;
	}
	/**
	 * @param univercityId the univercityId to set
	 */
	public void setUnivercityId(Integer univercityId) {
		this.univercityId = univercityId;
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
	 * @return the streamId
	 */
	public Integer getStreamId() {
		return streamId;
	}
	/**
	 * @param streamId the streamId to set
	 */
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	/**
	 * @return the edu_type
	 */
	public String getEdu_type() {
		return edu_type;
	}
	/**
	 * @param edu_type the edu_type to set
	 */
	public void setEdu_type(String edu_type) {
		this.edu_type = edu_type;
	}
	/**
	 * @return the percent_grade
	 */
	public String getPercent_grade() {
		return percent_grade;
	}
	/**
	 * @param string the percent_grade to set
	 */
	public void setPercent_grade(String string) {
		this.percent_grade = string;
	}
	/**
	 * @return the year_of_pass
	 */
	public String getYear_of_pass() {
		return year_of_pass;
		
	}
	/**
	 * @param yop the year_of_pass to set
	 */
	public void setYear_of_pass(String yop) {
		this.year_of_pass = yop;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the univercity
	 */
	public String getUnivercity() {
		return univercity;
	}
	/**
	 * @param univercity the univercity to set
	 */
	public void setUnivercity(String univercity) {
		this.univercity = univercity;
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
	 * @param string the pincode to set
	 */
	public void setPincode(String string) {
		this.pincode = string;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentEducationDetailsToVerifyBean [edu_type_Id="
				+ edu_type_Id + ", edu_type=" + edu_type + ", percent_grade="
				+ percent_grade + ", year_of_pass=" + year_of_pass
				+ ", stream=" + stream + ", college=" + college
				+ ", univercity=" + univercity + ", location=" + location
				+ ", pincode=" + pincode + ", city=" + city + ", state="
				+ state + ", country=" + country + ", userId=" + userId
				+ ", streamId=" + streamId + ", univercityId=" + univercityId
				+ ", cityId=" + cityId + "]";
	}
	
	
	

}
