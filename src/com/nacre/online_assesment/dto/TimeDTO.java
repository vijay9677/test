/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class TimeDTO implements Serializable {
        
	public TimeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer StudentCourseId;
	private Integer remainTime;
	private UserDTO user;
	private AssesmentDTO assesment;

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
	 * @return the remainTime
	 */
	public Integer getRemainTime() {
		return remainTime;
	}
	/**
	 * @param remainTime the remainTime to set
	 */
	public void setRemainTime(Integer remainTime) {
		this.remainTime = remainTime;
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
	/**
	 * @return the assesment
	 */
	public AssesmentDTO getAssesment() {
		return assesment;
	}
	/**
	 * @param assesment the assesment to set
	 */
	public void setAssesment(AssesmentDTO assesment) {
		this.assesment = assesment;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimeDTO [StudentCourseId=" + StudentCourseId + ", remainTime="
				+ remainTime + ", user=" + user + ", assesment=" + assesment
				+ "]";
	}

}
