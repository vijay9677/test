/**
 * 
 */
package com.nacre.online_assesment.vo;

import java.io.Serializable;

/**
 * @author Sagar Suryawanshi b 35
 *
 */
public class FindJobPostingVO implements Serializable {

	 private Integer companyName;
	 private Integer city;
	 private Integer technology;
	 /**
	 * @return the companyName
	 */
	public Integer getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(Integer companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the city
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * @return the technology
	 */
	public Integer getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(Integer technology) {
		this.technology = technology;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindJobPostingVO [companyName=" + companyName + ", city="
				+ city + ", technology=" + technology + "]";
	}
	
	
}
