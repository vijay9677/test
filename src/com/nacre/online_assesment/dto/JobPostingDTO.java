/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author nareshit
 *
 */
public class JobPostingDTO implements Serializable {

	public JobPostingDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer jobPostId;
	private String description;
	private Date expectedDate;
	private Date assStartDate;
	private Date assEndDate;
	private Date postDate;
	private Integer vacancies;
	private ClientAddressDTO clientaddress;
	private TechnologyDTO technology;
	/**
	 * @return the jobPostId
	 */
	public Integer getJobPostId() {
		return jobPostId;
	}
	/**
	 * @param jobPostId the jobPostId to set
	 */
	public void setJobPostId(Integer jobPostId) {
		this.jobPostId = jobPostId;
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
	 * @return the postDate
	 */
	public Date getPostDate() {
		return postDate;
	}
	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
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
	 * @return the clientaddress
	 */
	public ClientAddressDTO getClientaddress() {
		return clientaddress;
	}
	/**
	 * @param clientaddress the clientaddress to set
	 */
	public void setClientaddress(ClientAddressDTO clientaddress) {
		this.clientaddress = clientaddress;
	}
	/**
	 * @return the technology
	 */
	public TechnologyDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyDTO technology) {
		this.technology = technology;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobPostingDTO [jobPostId=" + jobPostId + ", description="
				+ description + ", expectedDate=" + expectedDate
				+ ", assStartDate=" + assStartDate + ", assEndDate="
				+ assEndDate + ", postDate=" + postDate + ", vacancies="
				+ vacancies + ", clientaddress=" + clientaddress
				+ ", technology=" + technology + "]";
	}
	
}
