/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class TechCourseDTO implements Serializable {
   public TechCourseDTO() {
	// TODO Auto-generated constructor stub
    }
   
   private Integer techCourseId;
	private CourseDTO course;
	private TechnologyDTO technology;
	/**
	 * @return the techCourseId
	 */
	public Integer getTechCourseId() {
		return techCourseId;
	}
	/**
	 * @param techCourseId the techCourseId to set
	 */
	public void setTechCourseId(Integer techCourseId) {
		this.techCourseId = techCourseId;
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
	 * @return the technology
	 */
	public TechnologyDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyDTO technology) {
		this.technology = technology;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechCourseDTO [techCourseId=" + techCourseId + ", course="
				+ course + ", technology=" + technology + "]";
	}

}
