package com.nacre.online_assesment.vo;

import java.io.Serializable;



/**
 * @authors Srikanth and krunal B35. 
 */

public class StudentCourseDetailsBean implements Serializable {
	
	private String course;
	private String technology;
	private Integer technologyId;
	/**
	 * @return the technologyId
	 */
	public Integer getTechnologyId() {
		return technologyId;
	}
	/**
	 * @param technologyId the technologyId to set
	 */
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	

}
