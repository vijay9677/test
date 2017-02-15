package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author vijay kumar P
 * @Description:This class using to get the notifications from database which
 *                   are using in ajax call
 */
public class JobDetailsToShowNotificationBean implements Serializable {

	private int jobPostingID;
	private String companyName;
	private String jobDescription;
	private String companyLogo;

	public JobDetailsToShowNotificationBean() {
		System.out.println("JobDetailsToShowNotificationBean  constructor");
	}

	/**
	 * @return the jobPostingID
	 */
	public int getJobPostingID() {
		return jobPostingID;
	}

	/**
	 * @param jobPostingID
	 *            the jobPostingID to set
	 */
	public void setJobPostingID(int jobPostingID) {
		this.jobPostingID = jobPostingID;
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
	 * @return the companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @param companyLogo
	 *            the companyLogo to set
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobDetailsToShowNotificationBean [jobPostingID=" + jobPostingID + ", companyName=" + companyName
				+ ", jobDescription=" + jobDescription + ", companyLogo=" + companyLogo + "]";
	}

}
