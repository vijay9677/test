/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;
import java.sql.Date;



/**
 * @author nareshit
 *
 */
public class EducationDetailsDTO implements Serializable {

	private Integer graduDetailsId;
	private String percentGrade;
	private Date yearOfPass;
	private AddressDTO address;
	private UserDTO user;
	private CollegeDTO college;
	private EducationTypeDTO educationType;
	private StreamDTO stream;
	/**
	 * @return the graduDetailsId
	 */
	public Integer getGraduDetailsId() {
		return graduDetailsId;
	}
	/**
	 * @param graduDetailsId the graduDetailsId to set
	 */
	public void setGraduDetailsId(Integer graduDetailsId) {
		this.graduDetailsId = graduDetailsId;
	}
	/**
	 * @return the percentGrade
	 */
	public String getPercentGrade() {
		return percentGrade;
	}
	/**
	 * @param percentGrade the percentGrade to set
	 */
	public void setPercentGrade(String percentGrade) {
		this.percentGrade = percentGrade;
	}
	/**
	 * @return the yearOfPass
	 */
	public Date getYearOfPass() {
		return yearOfPass;
	}
	/**
	 * @param yearOfPass the yearOfPass to set
	 */
	public void setYearOfPass(Date yearOfPass) {
		this.yearOfPass = yearOfPass;
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
	/**
	 * @return the college
	 */
	public CollegeDTO getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(CollegeDTO college) {
		this.college = college;
	}
	/**
	 * @return the educationType
	 */
	public EducationTypeDTO getEducationType() {
		return educationType;
	}
	/**
	 * @param educationType the educationType to set
	 */
	public void setEducationType(EducationTypeDTO educationType) {
		this.educationType = educationType;
	}
	/**
	 * @return the stream
	 */
	public StreamDTO getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(StreamDTO stream) {
		this.stream = stream;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EducationDetailsDTO [graduDetailsId=" + graduDetailsId
				+ ", percentGrade=" + percentGrade + ", yearOfPass="
				+ yearOfPass + ", address=" + address + ", user=" + user
				+ ", college=" + college + ", educationType=" + educationType
				+ ", stream=" + stream + "]";
	}
	

}
