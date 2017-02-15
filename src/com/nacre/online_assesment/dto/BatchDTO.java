/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class BatchDTO implements Serializable {

	/**
	 * 
	 */
	public BatchDTO() {
		// TODO Auto-generated constructor stub
	}

	private Integer batchId ;

	private String batch ;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BatchDTO [batchId=" + batchId + ", batch=" + batch + "]";
	}

	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}

	
}
