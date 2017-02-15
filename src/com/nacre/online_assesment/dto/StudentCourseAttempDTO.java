/**
 * 
 */
package com.nacre.online_assesment.dto;

/**
 * @author nareshit
 *
 */
public class StudentCourseAttempDTO {
  public StudentCourseAttempDTO() {
	// TODO Auto-generated constructor stub
    }
	private Integer attemptId;
	private Integer attemptNo;
	private Integer totalMarks;
    private UserDTO	user;
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
	 * @return the attemptNo
	 */
	public Integer getAttemptNo() {
		return attemptNo;
	}
	/**
	 * @param attemptNo the attemptNo to set
	 */
	public void setAttemptNo(Integer attemptNo) {
		this.attemptNo = attemptNo;
	}
	/**
	 * @return the totalMarks
	 */
	public Integer getTotalMarks() {
		return totalMarks;
	}
	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
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
	 * @return the technology
	 */
	public TechCourseDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechCourseDTO technology) {
		this.technology = technology;
	}
	private TechCourseDTO technology;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentCourseAttempDTO [attemptId=" + attemptId
				+ ", attemptNo=" + attemptNo + ", totalMarks=" + totalMarks
				+ ", user=" + user + ", technology=" + technology + "]";
	}
	
}
