/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.sql.Date;

/**
 * @author nareshit
 *
 */
public class PlacementDTO {

	public PlacementDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer placementId;
	private Date selectedDate;
	private Date joiningDate;
	private Float Package;
	private String bond;
	private ClientDTO client;
	private JobTypeDTO jobType;
	private UserDTO user;
	
	/**
	 * @return the package
	 */
	public Float getPackage() {
		return Package;
	}
	/**
	 * @param package the package to set
	 */
	public void setPackage(Float Package) {
		this.Package = Package;
	}
	/**
	 * @return the placementId
	 */
	public Integer getPlacementId() {
		return placementId;
	}
	/**
	 * @param placementId the placementId to set
	 */
	public void setPlacementId(Integer placementId) {
		this.placementId = placementId;
	}
	/**
	 * @return the selectedDate
	 */
	public Date getSelectedDate() {
		return selectedDate;
	}
	/**
	 * @param selectedDate the selectedDate to set
	 */
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	/**
	 * @return the bond
	 */
	public String getBond() {
		return bond;
	}
	/**
	 * @param bond the bond to set
	 */
	public void setBond(String bond) {
		this.bond = bond;
	}
	/**
	 * @return the client
	 */
	public ClientDTO getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	/**
	 * @return the jobType
	 */
	public JobTypeDTO getJobType() {
		return jobType;
	}
	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(JobTypeDTO jobType) {
		this.jobType = jobType;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/*public Integer getPackage() {
		return Package;
	}
	public void setPackage(Integer package1) {
		Package = package1;
	}*/
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlacementDTO [placementId=" + placementId + ", selectedDate="
				+ selectedDate + ", joiningDate=" + joiningDate + ", bond="
				+ bond + ", client=" + client + ", jobType=" + jobType
				+ ", user=" + user +",Package="+Package+ "]";
	}
	
}
