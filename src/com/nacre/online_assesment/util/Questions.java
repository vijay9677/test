package com.nacre.online_assesment.util;

import java.util.List;

public class Questions 
{
   String questionInd;
   String question;
   String level;
   List<QueOptions> QueOptions;
public String getQuestionInd() {
	return questionInd;
}
public void setQuestionInd(String questionInd) {
	this.questionInd = questionInd;
}
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
public List<QueOptions> getQueOptions() {
	return QueOptions;
}
public void setQueOptions(List<QueOptions> queOptions) {
	QueOptions = queOptions;
}
@Override
public String toString() {
	return "QuestionsList [questionInd=" + questionInd + ", question=" + question + ", level=" + level + ", QueOptions="
			+ QueOptions + "]";
}
   
   
}
