package com.nacre.online_assesment.form_bean;
/** 
 * @author Srinivas N
 * */
import java.io.Serializable;
import java.sql.Date;

public class JobPostingInsertionFormBean implements Serializable
{

	private Integer jobPostingId;
	private String description;
	private Date expectedDate;
	private Date assStartDate;
	private Date assEndDate;
	
	private Integer vacancies;
	private Integer clientaddressId;
	private Integer technologyId;
	private Integer addressId;
	
	
	
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
	 * @return the jobPostingId
	 */
	public Integer getJobPostingId() {
		return jobPostingId;
	}
	/**
	 * @param jobPostingId the jobPostingId to set
	 */
	public void setJobPostingId(Integer jobPostingId) {
		this.jobPostingId = jobPostingId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the expectedDate
	 */
	public Date getExpectedDate() {
		return expectedDate;
	}
	/**
	 * @param expectedDate the expectedDate to set
	 */
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	/**
	 * @return the assStartDate
	 */
	public Date getAssStartDate() {
		return assStartDate;
	}
	/**
	 * @param assStartDate the assStartDate to set
	 */
	public void setAssStartDate(Date assStartDate) {
		this.assStartDate = assStartDate;
	}
	/**
	 * @return the assEndDate
	 */
	public Date getAssEndDate() {
		return assEndDate;
	}
	/**
	 * @param assEndDate the assEndDate to set
	 */
	public void setAssEndDate(Date assEndDate) {
		this.assEndDate = assEndDate;
	}
	
	/**
	 * @return the vacancies
	 */
	public Integer getVacancies() {
		return vacancies;
	}
	/**
	 * @param vacancies the vacancies to set
	 */
	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}
	/**
	 * @return the clientaddressId
	 */
	public Integer getClientaddressId() {
		return clientaddressId;
	}
	/**
	 * @param clientaddressId the clientaddressId to set
	 */
	public void setClientaddressId(Integer clientaddressId) {
		this.clientaddressId = clientaddressId;
	}
	/**
	 * @return the technologyId
	 */
	public Integer getTechnologyId() {
		return technologyId;
	}
	/**
	 * @param technologyId the technologyId to set
	 */
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobPostingInsertionFormBean [jobPostingId=" + jobPostingId
				+ ", description=" + description + ", expectedDate="
				+ expectedDate + ", assStartDate=" + assStartDate
				+ ", assEndDate=" + assEndDate + ", vacancies=" + vacancies
				+ ", clientaddressId=" + clientaddressId + ", technologyId="
				+ technologyId + ", addressId=" + addressId + "]";
	}
	
	
	
		
}
