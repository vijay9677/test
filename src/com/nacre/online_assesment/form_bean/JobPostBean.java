package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class JobPostBean implements Serializable {
	
	private Integer Job_Post_Id;
	private String description;
	public Integer getJob_Post_Id() {
		return Job_Post_Id;
	}
	public void setJob_Post_Id(Integer job_Post_Id) {
		Job_Post_Id = job_Post_Id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
