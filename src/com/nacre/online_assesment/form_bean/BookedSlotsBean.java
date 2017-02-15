/**
 * 
 */
package com.nacre.online_assesment.form_bean;

import java.sql.Time;

import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.UserDTO;

/**
 * @author RROCK
 *
 */
public class BookedSlotsBean {
	
	private Time slotTime;
	private Integer assesmentId;
	private Integer userId;
	private Integer attempStatusId;
	
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
	 * @return the assesmentId
	 */
	public Integer getAssesmentId() {
		return assesmentId;
	}
	
	/**
	 * @param assesmentId the assesmentId to set
	 */
	public void setAssesmentId(Integer assesmentId) {
		this.assesmentId = assesmentId;
	}
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the attempStatusId
	 */
	public Integer getAttempStatusId() {
		return attempStatusId;
	}
	
	/**
	 * @param attempStatusId the attempStatusId to set
	 */
	public void setAttempStatusId(Integer attempStatusId) {
		this.attempStatusId = attempStatusId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookedSlotsBean [slotTime=" + slotTime + ", assesmentId=" + assesmentId + ", userId=" + userId
				+ ", attempStatusId=" + attempStatusId + "]";
	}
		
}
