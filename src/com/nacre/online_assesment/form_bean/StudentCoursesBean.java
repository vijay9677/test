package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class StudentCoursesBean implements Serializable{
	
	private String courses;
	private String technology;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
}
