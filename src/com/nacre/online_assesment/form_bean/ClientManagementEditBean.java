package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author Saurabh Suman  This Bean is used to make object of particular client details for editing or detail viewing 
 */

public class ClientManagementEditBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ClientName;
    private Integer ClientId;
    private String ClientImage;
    private String Description;
    private Integer companyLevel;
    
    /**
	 * @return the clientName
	 */
	public String getClientName() {
		return ClientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return ClientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		ClientId = clientId;
	}
	/**
	 * @return the clientImage
	 */
	public String getClientImage() {
		return ClientImage;
	}
	/**
	 * @param clientImage the clientImage to set
	 */
	public void setClientImage(String clientImage) {
		ClientImage = clientImage;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the companyLevel
	 */
	public Integer getCompanyLevel() {
		return companyLevel;
	}
	/**
	 * @param companyLevel the companyLevel to set
	 */
	public void setCompanyLevel(Integer companyLevel) {
		this.companyLevel = companyLevel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientManagementEditBean [ClientName=" + ClientName
				+ ", ClientId=" + ClientId + ", ClientImage=" + ClientImage
				+ ", Description=" + Description + ", companyLevel="
				+ companyLevel + "]";
	}
	

	
	
	
  

}
