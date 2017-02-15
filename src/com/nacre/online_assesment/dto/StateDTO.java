/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StateDTO implements Serializable{

	/**
	 * 
	 */
	public StateDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private Integer stateId ;
	
	/**
	 * 
	 */

	private String state ;

	
	
	/**
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}



	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the country
	 */
	public CountryDTO getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StateDTO [stateId=" + stateId + ", state=" + state + ", country=" + country + "]";
	}
	private CountryDTO country ;


}
