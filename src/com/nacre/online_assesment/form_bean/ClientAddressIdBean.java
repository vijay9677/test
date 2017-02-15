package com.nacre.online_assesment.form_bean;





/**
 * @ author Amarendar Guthuru
 *This ClientAddressIDBean class is created setting values to the respected values
 * So we can access this values through out the application by getter methods
 */



public class ClientAddressIdBean {
	
	private Integer clientid;
	private Integer addressid;
	private Integer clientaddressid;
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
	 * @return the addressid
	 */
	public Integer getAddressid() {
		return addressid;
	}
	/**
	 * @param addressid the addressid to set
	 */
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	/**
	 * @return the clientaddressid
	 */
	public Integer getClientaddressid() {
		return clientaddressid;
	}
	/**
	 * @param clientaddressid the clientaddressid to set
	 */
	public void setClientaddressid(Integer clientaddressid) {
		this.clientaddressid = clientaddressid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientAddressIdBean [clientid=" + clientid + ", addressid=" + addressid + ", clientaddressid="
				+ clientaddressid + "]";
	}
	

}
