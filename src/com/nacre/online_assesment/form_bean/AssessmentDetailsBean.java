package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chitranshu Gupta  This Bean used to save assessment details
 */


public class AssessmentDetailsBean implements Serializable {

	private Integer assessmentId=null;
	private String assessmentName=null;
	private Integer assessmentTotalMarks=null;
	private Integer assessmentDuration=null;
	private Date assessmentDate=null;
	private String assessmentDesc=null;
	private Integer assessmentTotalQuestions=null;
	public Integer getAssessmentId() {
		return assessmentId;
		//--------
	}
	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public Integer getAssessmentTotalMarks() {
		return assessmentTotalMarks;
	}
	public void setAssessmentTotalMarks(Integer assessmentTotalMarks) {
		this.assessmentTotalMarks = assessmentTotalMarks;
	}
	public Integer getAssessmentDuration() {
		return assessmentDuration;
	}
	public void setAssessmentDuration(Integer assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}
	public Date getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public String getAssessmentDesc() {
		return assessmentDesc;
	}
	public void setAssessmentDesc(String assessmentDesc) {
		this.assessmentDesc = assessmentDesc;
	}
	public Integer getAssessmentTotalQuestions() {
		return assessmentTotalQuestions;
	}
	public void setAssessmentTotalQuestions(Integer assessmentTotalQuestions) {
		this.assessmentTotalQuestions = assessmentTotalQuestions;
	}
	@Override
	public String toString() {
		return "AssessmentDetailsBean [assessmentId=" + assessmentId + ", assessmentName=" + assessmentName
				+ ", assessmentTotalMarks=" + assessmentTotalMarks + ", assessmentDuration=" + assessmentDuration
				+ ", assessmentDate=" + assessmentDate + ", assessmentDesc=" + assessmentDesc
				+ ", assessmentTotalQuestions=" + assessmentTotalQuestions + "]";
	}
	
	
}
