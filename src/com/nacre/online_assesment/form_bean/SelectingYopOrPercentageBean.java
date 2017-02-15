package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author vijay
 * @Description this class is using getting data from database which fields data
 *              used ajax call which is filtered data percentage or year of
 *              passed outs or both
 * 
 */

public class SelectingYopOrPercentageBean implements Serializable {

	private int userNo;
	private String emailId;
	private String firstName;
	private String lastNmae;
	private int yop;
	private String percetage;

	/**
	 * 
	 */
	public SelectingYopOrPercentageBean() {
		System.out.println("SelectedStudentsBean constuctor is called");
	}

	/**
	 * @return the userNo
	 */
	public int getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo
	 *            the userNo to set
	 */
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastNmae
	 */
	public String getLastNmae() {
		return lastNmae;
	}

	/**
	 * @param lastNmae
	 *            the lastNmae to set
	 */
	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
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
	 * @return the percetage
	 */
	public String getPercetage() {
		return percetage;
	}

	/**
	 * @param percetage
	 *            the percetage to set
	 */
	public void setPercetage(String percetage) {
		this.percetage = percetage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectingYopOrPercentageBean [userNo=" + userNo + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastNmae=" + lastNmae + ", yop=" + yop + ", percetage=" + percetage + "]";
	}

}
