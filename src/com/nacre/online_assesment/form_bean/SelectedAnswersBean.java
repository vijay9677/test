package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class SelectedAnswersBean implements Serializable {
//---------
	private Integer assessmentQuestionId = null;
	private Integer selectedOption = null;
	public Integer getAssessmentQuestionId() {
		return assessmentQuestionId;
	}
	public void setAssessmentQuestionId(Integer assessmentQuestionId) {
		this.assessmentQuestionId = assessmentQuestionId;
	}
	public Integer getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(Integer selectedOption) {
		this.selectedOption = selectedOption;
	}
	@Override
	public String toString() {
		return "SelectedAnswersBean [assessmentQuestionId=" + assessmentQuestionId + ", selectedOption="
				+ selectedOption + "]";
	}
	
	
}
