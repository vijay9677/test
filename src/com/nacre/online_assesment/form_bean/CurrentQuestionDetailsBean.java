package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author Chitranshu Gupta  This Bean used to save current Question details
 */

public class CurrentQuestionDetailsBean implements Serializable {
//---------
	private String selectedOptions = null;
	private Integer assessmentQuesId = null;
	private Integer userId = null;
	private String remainingTime = null; 
	private Integer assessmentId = null;
	public String getSelectedOptions() {
		return selectedOptions;
	}
	public void setSelectedOptions(String selectedOptions) {
		this.selectedOptions = selectedOptions;
	}
	public Integer getAssessmentQuesId() {
		return assessmentQuesId;
	}
	public void setAssessmentQuesId(Integer assessmentQuesId) {
		this.assessmentQuesId = assessmentQuesId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRemainingTime() {
		return remainingTime;
	}
	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}
	public Integer getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}
	@Override
	public String toString() {
		return "CurrentQuestionDetailsBean [selectedOptions=" + selectedOptions + ", assessmentQuesId="
				+ assessmentQuesId + ", userId=" + userId + ", remainingTime=" + remainingTime + ", assessmentId="
				+ assessmentId + "]";
	}
	
	
}
