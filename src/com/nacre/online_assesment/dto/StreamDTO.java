/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author nareshit
 *
 */
public class StreamDTO implements Serializable {
	
	private Integer streamId;
	private String stream;
	/**
	 * @return the streamId
	 */
	public Integer getStreamId() {
		return streamId;
	}
	/**
	 * @param streamId the streamId to set
	 */
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	

}
