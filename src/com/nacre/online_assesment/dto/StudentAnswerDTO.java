/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class StudentAnswerDTO implements Serializable {

	public StudentAnswerDTO() {
		// TODO Auto-generated constructor stub
	}
	private Integer answerId;
	private AssesmentQuestionDTO question;
	private QuestionOptionDTO option;

	/**
	 * @return the answerId
	 */
	public Integer getAnswerId() {
		return answerId;
	}
	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	/**
	 * @return the question
	 */
	public AssesmentQuestionDTO getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(AssesmentQuestionDTO question) {
		this.question = question;
	}
	/**
	 * @return the option
	 */
	public QuestionOptionDTO getOption() {
		return option;
	}
	/**
	 * @param option the option to set
	 */
	public void setOption(QuestionOptionDTO option) {
		this.option = option;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentAnswerDTO [answerId=" + answerId + ", question="
				+ question + ", option=" + option + "]";
	}
	
}
