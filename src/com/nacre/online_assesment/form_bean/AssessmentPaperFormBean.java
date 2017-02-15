package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class AssessmentPaperFormBean implements Serializable
 {
   
    
	
	private QuestionsFormBean questionsFormBean;
	private List OptionsFormBean;
	
	public QuestionsFormBean getQuestionsFormBean() {
		return questionsFormBean;
	}
	public void setQuestionsFormBean(QuestionsFormBean questionsFormBean) {
		this.questionsFormBean = questionsFormBean;
	}
	public List getOptionsFormBean() {
		return OptionsFormBean;
	}
	public void setOptionsFormBean(List optionsFormBean) {
		OptionsFormBean = optionsFormBean;
	}
	@Override
	public String toString() {
		return "AssessmentPaperFormBean [questionsFormBean=" + questionsFormBean + ", OptionsFormBean="
				+ OptionsFormBean + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
