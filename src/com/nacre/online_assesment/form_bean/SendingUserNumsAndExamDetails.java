package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author vijay kumar P
 * @Description:This class using to filter the students and email who are short
 *                   listed and which is using in sending notification to
 *                   student
 */
public class SendingUserNumsAndExamDetails implements Serializable {

	private int jobPostId;
	private String date;
	private String examName;
	private List userNo;

	public SendingUserNumsAndExamDetails() {
		System.out.println("SendingUserNumsAndExamDetails constructor");
	}

	/**
	 * @return the jobPostId
	 */
	public int getJobPostId() {
		return jobPostId;
	}

	/**
	 * @param jobPostId
	 *            the jobPostId to set
	 */
	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the examName
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * @param examName
	 *            the examName to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}

	/**
	 * @return the userNo
	 */
	public List getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo
	 *            the userNo to set
	 */
	public void setUserNo(List userNo) {
		this.userNo = userNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SendingUserNumsAndExamDetails [date=" + date + ", examName=" + examName + ", userNo=" + userNo + "]";
	}

}
