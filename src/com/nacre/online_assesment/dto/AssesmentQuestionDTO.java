/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AssesmentQuestionDTO implements Serializable {

	/**
	 * 
	 */
	public AssesmentQuestionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer assesmentQuestionId;
	private AssesmentDTO assesment;
	private QuestionDTO question;
	/**
	 * @return the assesmentQuestionId
	 */
	public Integer getAssesmentQuestionId() {
		return assesmentQuestionId;
	}
	/**
	 * @param assesmentQuestionId the assesmentQuestionId to set
	 */
	public void setAssesmentQuestionId(Integer assesmentQuestionId) {
		this.assesmentQuestionId = assesmentQuestionId;
	}
	/**
	 * @return the assesment
	 */
	public AssesmentDTO getAssesment() {
		return assesment;
	}
	/**
	 * @param assesment the assesment to set
	 */
	public void setAssesment(AssesmentDTO assesment) {
		this.assesment = assesment;
	}
	/**
	 * @return the question
	 */
	public QuestionDTO getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssesmentQuestionDTO [assesmentQuestionId=" + assesmentQuestionId + ", assesment=" + assesment
				+ ", question=" + question + "]";
	}
	
	
	
	

}
