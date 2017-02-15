package com.nacre.online_assesment.form_bean;


/**
 * @ author Amarendar Guthuru
 *This ClientAddressBean class is created setting values to the respected values
 * So we can access this values through out the application by getter methods
 */



public class ClientAddressBean {

	private Integer clientid;
	private Integer cityid;
	private String location;
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	private int addressId;
	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the clientid
	 */
	public Integer getClientid() {
		return clientid;
	}
	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	/**
	 * @return the cityid
	 */
	public Integer getCityid() {
		return cityid;
	}
	/**
	 * @param cityid the cityid to set
	 */
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
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
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the pincode
	 */
	public Integer getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientAddressBean [clientid=" + clientid + ", cityid=" + cityid + ", location=" + location + ", city="
				+ city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
	 
}
