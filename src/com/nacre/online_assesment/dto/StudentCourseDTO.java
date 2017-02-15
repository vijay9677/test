/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class StudentCourseDTO implements Serializable {
  public StudentCourseDTO() {
	// TODO Auto-generated constructor stub
     }
	private Integer StudentCourseId;
	private CourseDTO course;
	private UserDTO user;
	/**
	 * @return the studentCourseId
	 */
	public Integer getStudentCourseId() {
		return StudentCourseId;
	}
	/**
	 * @param studentCourseId the studentCourseId to set
	 */
	public void setStudentCourseId(Integer studentCourseId) {
		StudentCourseId = studentCourseId;
	}
	/**
	 * @return the course
	 */
	public CourseDTO getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentCourseDTO [StudentCourseId=" + StudentCourseId
				+ ", course=" + course + ", user=" + user + "]";
	}
	
}
