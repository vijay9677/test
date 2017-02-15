/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AddressDTO implements Serializable {

	/**
	 * 
	 */
	public AddressDTO() {
		// TODO Auto-generated constructor stub
	}


	private Integer addressId ;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", pincode=" + pincode + ", location=" + location + ", city="
				+ city + "]";
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * @return the city
	 */
	public CityDTO getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(CityDTO city) {
		this.city = city;
	}



	private String pincode ;
	private String location ;
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	private CityDTO city ;
	
}
