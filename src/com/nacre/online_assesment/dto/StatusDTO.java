/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StatusDTO implements Serializable {

	/**
	 * 
	 */
	public StatusDTO() {
		// TODO Auto-generated constructor stub
	}

/**
 * 	
 */
	private Integer statusId ;

	/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "StatusDTO [statusId=" + statusId + ", status=" + status + "]";
}

	/**
 * @return the statusId
 */
public Integer getStatusId() {
	return statusId;
}

/**
 * @param statusId the statusId to set
 */
public void setStatusId(Integer statusId) {
	this.statusId = statusId;
}

/**
 * @return the status
 */
public String getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}

	/**
	 * 
	 */
	private String status ;

}
