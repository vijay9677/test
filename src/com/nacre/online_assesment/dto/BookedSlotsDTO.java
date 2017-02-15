package com.nacre.online_assesment.dto;

import java.io.Serializable;
import java.sql.Time;
/**
 * @author Vijay Kumar Reddy K
 *
 */
public class BookedSlotsDTO implements Serializable {
	/**
	 * 
	 */
	public BookedSlotsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer bookslotsId;
	private Time slotTime;
	private AssesmentDTO assesment;
	private UserDTO user;
	private StatusDTO status;
	
	/**
	 * @return the bookslotsId
	 */
	public Integer getBookslotsId() {
		return bookslotsId;
	}

	/**
	 * @param bookslotsId the bookslotsId to set
	 */
	public void setBookslotsId(Integer bookslotsId) {
		this.bookslotsId = bookslotsId;
	}

	/**
	 * @return the slotTime
	 */
	public Time getSlotTime() {
		return slotTime;
	}

	/**
	 * @param slotTime the slotTime to set
	 */
	public void setSlotTime(Time slotTime) {
		this.slotTime = slotTime;
	}

	/**
	 * @return the assesment
	 */
	public AssesmentDTO getAssesment() {
		return assesment;
	}

	/**
	 * @param assesment the assesment to set
	 */
	public void setAssesment(AssesmentDTO assesment) {
		this.assesment = assesment;
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

	@Override
	public String toString() {
		return "BookedSlotsDTO [bookslotsId=" + bookslotsId + ", slotTime="
				+ slotTime + ", assesment=" + assesment + ", user=" + user
				+ ", status=" + status + "]";
	}
	
}
