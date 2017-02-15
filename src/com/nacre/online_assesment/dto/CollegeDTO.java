/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class CollegeDTO implements Serializable {

	private Integer collegeId;
	private String college;
	private UniversityDTO university;
	/**
	 * @return the collegeId
	 */
	public Integer getCollegeId() {
		return collegeId;
	}
	/**
	 * @param collegeId the collegeId to set
	 */
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the university
	 */
	public UniversityDTO getUniversity() {
		return university;
	}
	/**
	 * @param university the university to set
	 */
	public void setUniversity(UniversityDTO university) {
		this.university = university;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollegeDTO [collegeId=" + collegeId + ", college=" + college
				+ ", university=" + university + "]";
	}
	


}
