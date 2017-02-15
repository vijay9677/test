/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class QuestionOptionDTO implements Serializable {

	public QuestionOptionDTO() {
		// TODO Auto-generated constructor stub
	}
	private Integer optionId;
	private String option;
	private Integer isAnswer;
	private QuestionDTO question;
	/**
	 * @return the optionId
	 */
	public Integer getOptionId() {
		return optionId;
	}
	/**
	 * @param optionId the optionId to set
	 */
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}
	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}
	/**
	 * @return the isAnswer
	 */
	public Integer getIsAnswer() {
		return isAnswer;
	}
	/**
	 * @param isAnswer the isAnswer to set
	 */
	public void setIsAnswer(Integer isAnswer) {
		this.isAnswer = isAnswer;
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
		return "QuestionOptionDTO [optionId=" + optionId + ", option=" + option
				+ ", isAnswer=" + isAnswer + ", question=" + question + "]";
	}
	

}
