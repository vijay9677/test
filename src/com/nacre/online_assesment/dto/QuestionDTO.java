/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class QuestionDTO implements Serializable {

	/**
	 * 
	 */
	public QuestionDTO() {
		// TODO Auto-generated constructor stub
	}
	private Integer questionId;
	private String question;
	private LevelDTO level;
	/**
	 * @return the questionId
	 */
	public Integer getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the level
	 */
	public LevelDTO getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(LevelDTO level) {
		this.level = level;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionDTO [questionId=" + questionId + ", question=" + question + ", level=" + level + "]";
	}
	
	
	

}
