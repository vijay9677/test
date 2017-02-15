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
public class InterviewRoundDTO implements Serializable {

	private Integer roundId;
	private Integer roundNo;
	private JobPostingDTO jobPost;
	private Integer jobPostId;
	private String description;
	private Date date;
	private StatusDTO status;
	private AddressDTO address;

	/**
	 * @return the roundId
	 */
	public Integer getRoundId() {
		return roundId;
	}
	/**
	 * @param roundId the roundId to set
	 */
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	/**
	 * @return the roundNo
	 */
	public Integer getRoundNo() {
		return roundNo;
	}
	/**
	 * @param roundNo the roundNo to set
	 */
	public void setRoundNo(Integer roundNo) {
		this.roundNo = roundNo;
	}
	public Integer getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(Integer jobPostId) {
		this.jobPostId = jobPostId;
	}
	/**
	 * @return the jobPost
	 */
	public JobPostingDTO getJobPost() {
		return jobPost;
	}
	/**
	 * @param jobPost the jobPost to set
	 */
	public void setJobPost(JobPostingDTO jobPost) {
		this.jobPost = jobPost;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the status
	 */
	public StatusDTO getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InterviewRoundDTO [roundId=" + roundId + ", roundNo=" + roundNo
				+ ", jobPost=" + jobPost + ", description=" + description
				+ ", date=" + date + ", status=" + status + ", address="
				+ address + "]";
	}
	
}
