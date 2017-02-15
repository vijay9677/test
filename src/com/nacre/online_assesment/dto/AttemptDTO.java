/**
 * 
 */
package com.nacre.online_assesment.dto;

/**
 * @author nareshit
 *
 */
public class AttemptDTO {
	public AttemptDTO() {
		// TODO Auto-generated constructor stub
	}
	  private Integer attemptId;
	  private Integer noOfAttempt;
	  private TechCourseDTO techCourse;
	/**
	 * @return the attemptId
	 */
	public Integer getAttemptId() {
		return attemptId;
	}
	/**
	 * @param attemptId the attemptId to set
	 */
	public void setAttemptId(Integer attemptId) {
		this.attemptId = attemptId;
	}
	/**
	 * @return the noOfAttempt
	 */
	public Integer getNoOfAttempt() {
		return noOfAttempt;
	}
	/**
	 * @param noOfAttempt the noOfAttempt to set
	 */
	public void setNoOfAttempt(Integer noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}
	/**
	 * @return the techCourse
	 */
	public TechCourseDTO getTechCourse() {
		return techCourse;
	}
	/**
	 * @param techCourse the techCourse to set
	 */
	public void setTechCourse(TechCourseDTO techCourse) {
		this.techCourse = techCourse;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AttemptDTO [attemptId=" + attemptId + ", noOfAttempt="
				+ noOfAttempt + ", techCourse=" + techCourse + "]";
	}


}
