/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class TechnologyDTO implements Serializable {

	/**
	 * 
	 */
	public TechnologyDTO() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechnologyDTO [technologyId=" + technologyId + ", technology=" + technology + "]";
	}
	private Integer technologyId ;

	private String technology ;

	/**
	 * @return the technologyId
	 */
	public Integer getTechnologyId() {
		return technologyId;
	}

	/**
	 * @param technologyId the technologyId to set
	 */
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}


}
