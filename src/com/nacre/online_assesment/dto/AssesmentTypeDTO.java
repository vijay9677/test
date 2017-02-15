/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AssesmentTypeDTO implements Serializable {

	/**
	 * 
	 */
	public AssesmentTypeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer assesmentTypeId;
	private String assesmentTypeName;
	/**
	 * @return the assesmentTypeId
	 */
	public Integer getAssesmentTypeId() {
		return assesmentTypeId;
	}
	/**
	 * @param assesmentTypeId the assesmentTypeId to set
	 */
	public void setAssesmentTypeId(Integer assesmentTypeId) {
		this.assesmentTypeId = assesmentTypeId;
	}
	/**
	 * @return the assesmentTypeName
	 */
	public String getAssesmentTypeName() {
		return assesmentTypeName;
	}
	/**
	 * @param assesmentTypeName the assesmentTypeName to set
	 */
	public void setAssesmentTypeName(String assesmentTypeName) {
		this.assesmentTypeName = assesmentTypeName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssesmentType [assesmentTypeId=" + assesmentTypeId + ", assesmentTypeName=" + assesmentTypeName + "]";
	}
	
	

}
