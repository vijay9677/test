package com.nacre.online_assesment.vo;

import java.io.Serializable;

public class ClientAddressDetailVo implements Serializable{

	private String client_name;
	private Integer address_id;
	private String location;
	private String pincode;
    private String city;	
	private String state;
	private String country;
	private Integer clientAddressId;
	/**
	 * @return the client_name
	 */
	public String getClient_name() {
		return client_name;
	}
	/**
	 * @param client_name the client_name to set
	 */
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	/**
	 * @return the address_id
	 */
	public Integer getAddress_id() {
		return address_id;
	}
	/**
	 * @param address_id the address_id to set
	 */
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
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
	 * @return the clientAddressId
	 */
	public Integer getClientAddressId() {
		return clientAddressId;
	}
	/**
	 * @param clientAddressId the clientAddressId to set
	 */
	public void setClientAddressId(Integer clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientAddressDetailVo [client_name=" + client_name
				+ ", address_id=" + address_id + ", location=" + location
				+ ", pincode=" + pincode + ", city=" + city + ", state="
				+ state + ", country=" + country + ", clientAddressId="
				+ clientAddressId + "]";
	}
	
	
	
	
}
