package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.util.Date;



public class StudentEducationBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
		private Integer user_id;
	   
	    private String edu_type;
	    /**
	     * @return Integer
	     */
		private String percent_grade;
		
		private Date year_of_pass;
		private String stream;
		private Integer streamId;
		
		private String college;
		private String univercity;
		private Integer universityId;
		private String location;
		private Integer pincode;
		private String city;
		private Integer cityId;
		
		private String state;
		private String country;
		
		
		public Integer getUniversityId() {
			return universityId;
		}
		public void setUniversityId(Integer universityId) {
			this.universityId = universityId;
		}
		public Integer getStreamId() {
			return streamId;
		}
		public void setStreamId(Integer streamId) {
			this.streamId = streamId;
		}
		
		public Integer getCityId() {
			return cityId;
		}
		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}
		
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
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
		 * @param perc the percent_grade to set
		 */
		public void setPercent_grade(String perc) {
			this.percent_grade = perc;
		}
		/**
		 * @return the year_of_pass
		 */
		public Date getYear_of_pass() {
			return year_of_pass;
			
		}
		/**
		 * @param date the year_of_pass to set
		 */
		
		
		
		public void setYear_of_pass(Date date) {
			this.year_of_pass = date;
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
		public Integer getPincode() {
			return pincode;
		}
		/**
		 * @param pincode the pincode to set
		 */
		public void setPincode(Integer pincode) {
			this.pincode = pincode;
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
		@Override
		public String toString() {
			return "StudentEducationBean [edu_type=" + edu_type
					+ ", percent_grade=" + percent_grade + ", year_of_pass="
					+ year_of_pass + ", stream=" + stream + ", college="
					+ college + ", univercity=" + univercity + ", location="
					+ location + ", pincode=" + pincode + ", city=" + city
					+ ", state=" + state + ", country=" + country + "]";
		}
		
	}
