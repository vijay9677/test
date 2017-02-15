/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CityDTO implements Serializable {

	/**
	 * 
	 */
	public CityDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private Integer cityId ;
	
	/**
	 * 
	 */

	private String city ;


	private StateDTO state ;


	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}


	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityDTO [cityId=" + cityId + ", city=" + city + ", state=" + state + "]";
	}


	/**
	 * @return the state
	 */
	public StateDTO getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(StateDTO state) {
		this.state = state;
	}	
	

}
