/**
 * 
 */
package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author Krishna Prakash
 *
 */
public class QuestionsFormBean implements Serializable
{
   private String question;
   private String level="simple";
   private Boolean isDuplicate;
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public Boolean getIsDuplicate() {
	return isDuplicate;
}
public void setIsDuplicate(Boolean isDuplicate) {
	this.isDuplicate = isDuplicate;
}
@Override
public String toString() {
	return "QuestionsFormBean [question=" + question + ", level=" + level + ", isDuplicate=" + isDuplicate + "]";
}
   
}
