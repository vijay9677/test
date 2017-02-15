/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String mobileNo;
	private Integer gender;
	private String image;
	private Date date;
	private Integer isNacre;
	private RoleDTO role;
	private AddressDTO address;
	private StatusDTO status;
	private BatchDTO batch;
	private TechnologyDTO technology;
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the isNacre
	 */
	public Integer getIsNacre() {
		return isNacre;
	}
	/**
	 * @param isNacre the isNacre to set
	 */
	public void setIsNacre(Integer isNacre) {
		this.isNacre = isNacre;
	}
	/**
	 * @return the role
	 */
	public RoleDTO getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleDTO role) {
		this.role = role;
	}
	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	/**
	 * @return the status
	 */
	public StatusDTO getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	/**
	 * @return the batch
	 */
	public BatchDTO getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(BatchDTO batch) {
		this.batch = batch;
	}
	/**
	 * @return the technology
	 */
	public TechnologyDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyDTO technology) {
		this.technology = technology;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", mobileNo=" + mobileNo + ", gender=" + gender 
				+ ", date=" + date + ", isNacre=" + isNacre + ", role=" + role + ", address=" + address + ", status="
				+ status + ", batch=" + batch + ", technology=" + technology + "]";
	}
	
	
	
	
	
	

}
