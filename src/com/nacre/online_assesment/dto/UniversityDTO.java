/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class UniversityDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer universityId;
	private String universityName;
	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	@Override
	public String toString() {
		return "UniversityDTO [universityId=" + universityId
				+ ", universityName=" + universityName + "]";
	}
	

private Integer univ_Id;
private String univercity;
/**
 * @return the univ_Id
 */
public Integer getUniv_Id() {
	return univ_Id;
}
/**
 * @param univ_Id the univ_Id to set
 */
public void setUniv_Id(Integer univ_Id) {
	this.univ_Id = univ_Id;
}
/**
 * @return the univercity
 */
public String getUnivercity() {
	return univercity;
}
/**
 * @param univercity the univercity to set
 */
public void setUnivercity(String univercity) {
	this.univercity = univercity;
}
}
