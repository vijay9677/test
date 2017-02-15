package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class OptionsFromBean implements Serializable
{
  private String option;
  private Boolean isAnswer=false;
  private Boolean isDuplicate=false;
public String getOption() 
{
	return option;
}
public void setOption(String option)
{
	this.option = option;
}
public Boolean getIsAnswer() 
{
	return isAnswer;
}
public void setIsAnswer(Boolean isAnswer) 
{
	this.isAnswer = isAnswer;
}
public Boolean getIsDuplicate() 
{
	return isDuplicate;
}
public void setIsDuplicate(Boolean isDuplicate) 
{
	this.isDuplicate = isDuplicate;
}
@Override
public String toString() 
{
	return "OptionsFromBean [option=" + option + ", isAnswer=" + isAnswer + ", isDuplicate=" + isDuplicate + "]";
}
  
}
