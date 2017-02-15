package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.sql.Date;

public class JobDetailsBean implements Serializable {
	
	
	/**
	 * @author Gajanan Debadwar  This Bean to Store Details of Notifications
	 */

	private static final long serialVersionUID = 1L;
	private  String companyName;
	private  String companyLogo;
	private  String companyDescription;
	private  String jobDescription;
	private  String contactPersonName;
	private  String contactPersonMail;
	private  String contactPersonMobno;
	private  String technology;
	private  String location;
	private  String city;
	private  String state;
	private  String country;
	private  Date   postedOn,assesmentStartDate,assesmentEndDate,expectedDate;
	private  int    vacancy;
	private  int    jobPostingID;
	
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
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContactPersonMail() {
		return contactPersonMail;
	}
	public void setContactPersonMail(String contactPersonMail) {
		this.contactPersonMail = contactPersonMail;
	}
	public String getContactPersonMobno() {
		return contactPersonMobno;
	}
	public void setContactPersonMobno(String contactPersonMobno) {
		this.contactPersonMobno = contactPersonMobno;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	public Date getAssesmentStartDate() {
		return assesmentStartDate;
	}
	public void setAssesmentStartDate(Date assesmentStartDate) {
		this.assesmentStartDate = assesmentStartDate;
	}
	public Date getAssesmentEndDate() {
		return assesmentEndDate;
	}
	public void setAssesmentEndDate(Date assesmentEndDate) {
		this.assesmentEndDate = assesmentEndDate;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getJobPostingID() {
		return jobPostingID;
	}
	public void setJobPostingID(int jobPostingID) {
		this.jobPostingID = jobPostingID;
	}
	@Override
	public String toString() {
		return "JobDetailsBean [companyName=" + companyName + ", companyLogo=" + companyLogo + ", companyDescription="
				+ companyDescription + ", jobDescription=" + jobDescription + ", contactPersonName=" + contactPersonName
				+ ", contactPersonMail=" + contactPersonMail + ", contactPersonMobno=" + contactPersonMobno
				+ ", technology=" + technology + ", location=" + location + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", postedOn=" + postedOn + ", assesmentStartDate=" + assesmentStartDate
				+ ", assesmentEndDate=" + assesmentEndDate + ", expectedDate=" + expectedDate + ", vacancy=" + vacancy
				+ ", jobPostingID=" + jobPostingID + "]";
	}
	
	
	
	

}
