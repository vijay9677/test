/**
 * 
 */
package com.nacre.online_assesment.form_bean;

/**
 * @author RROCK
 *
 */
public class AssesmentTypeBean {

	private Integer assTypeId;
	private String assTypeName;
	/**
	 * @return the assTypeId
	 */
	public Integer getAssTypeId() {
		return assTypeId;
	}
	/**
	 * @param assTypeId the assTypeId to set
	 */
	public void setAssTypeId(Integer assTypeId) {
		this.assTypeId = assTypeId;
	}
	/**
	 * @return the assTypeName
	 */
	public String getAssTypeName() {
		return assTypeName;
	}
	/**
	 * @param assTypeName the assTypeName to set
	 */
	public void setAssTypeName(String assTypeName) {
		this.assTypeName = assTypeName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssesmentTypeBean [assTypeId=" + assTypeId + ", assTypeName=" + assTypeName + "]";
	}
	
	
}
