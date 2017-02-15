package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author vijay kumar P
 * @Description this class using to filter the students and email who are
 *              shortlisted
 * 
 */
public class ShareJobOppertunityFormBean implements Serializable {

	private String details;

	private String percentage;
	private int yop;
	private int status;

	public ShareJobOppertunityFormBean() {
		System.out.println("sharejoboppertunity constructor");
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage
	 *            the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the yop
	 */
	public int getYop() {
		return yop;
	}

	/**
	 * @param yop
	 *            the yop to set
	 */
	public void setYop(int yop) {
		this.yop = yop;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShareJobOppertunityFormBean [details=" + details + ", percentage=" + percentage + ", yop=" + yop
				+ ", status=" + status + "]";
	}

}
