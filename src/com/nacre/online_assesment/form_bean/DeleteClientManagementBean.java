package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class DeleteClientManagementBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer clientId;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "DeleteClientManagementBean [clientId=" + clientId + "]";
	}
	

}
