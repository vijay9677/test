/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CourseDTO implements Serializable{

	/**
	 * 
	 */
	public CourseDTO() {
		// TODO Auto-generated constructor stub
	}
	private Integer courseId;
	private String course;
	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseDTO [courseId=" + courseId + ", course=" + course + "]";
	}
	
	

}
