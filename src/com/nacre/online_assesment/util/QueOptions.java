package com.nacre.online_assesment.util;

public class QueOptions {
	String option;
	Boolean isAnswer;
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Boolean getIsAnswer() {
		return isAnswer;
	}
	public void setIsAnswer(Boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	@Override
	public String toString() {
		return "QueOptions [option=" + option + ", isAnswer=" + isAnswer + "]";
	}
	

}
