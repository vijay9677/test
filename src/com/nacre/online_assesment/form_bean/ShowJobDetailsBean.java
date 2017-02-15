package com.nacre.online_assesment.form_bean;

import java.sql.Date;

public class ShowJobDetailsBean {
	
	private int jobPostId;
	private String companyDescription;
	private String jobDescription;
	private Date expectedDate;
	private Date assStartDate;
	private Date assEndDate;
	private Date postDate;
	private String clientName;
	private String location;
	private String city;
	private String state;
	private String technology;
	private String clientEmail;
	private String clientMobNO;
	private int vacancies;
	private String images;
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
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
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Date getAssStartDate() {
		return assStartDate;
	}
	public void setAssStartDate(Date assStartDate) {
		this.assStartDate = assStartDate;
	}
	public Date getAssEndDate() {
		return assEndDate;
	}
	public void setAssEndDate(Date assEndDate) {
		this.assEndDate = assEndDate;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientMobNO() {
		return clientMobNO;
	}
	public void setClientMobNO(String clientMobNO) {
		this.clientMobNO = clientMobNO;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	@Override
	public String toString() {
		return "ShowJobDetailsBean [jobPostId=" + jobPostId + ", companyDescription=" + companyDescription
				+ ", jobDescription=" + jobDescription + ", expectedDate=" + expectedDate + ", assStartDate="
				+ assStartDate + ", assEndDate=" + assEndDate + ", postDate=" + postDate + ", clientName=" + clientName
				+ ", location=" + location + ", city=" + city + ", state=" + state + ", technology=" + technology
				+ ", clientEmail=" + clientEmail + ", clientMobNO=" + clientMobNO + ", vacancies=" + vacancies
				+ ", images=" + images + "]";
	}

}
