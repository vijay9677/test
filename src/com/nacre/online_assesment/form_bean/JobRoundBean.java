package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class JobRoundBean implements Serializable {
	
	private Integer interview_round_id;
	private String round_description;
	public Integer getInterview_round_id() {
		return interview_round_id;
	}
	public void setInterview_round_id(Integer interview_round_id) {
		this.interview_round_id = interview_round_id;
	}
	public String getRound_description() {
		return round_description;
	}
	public void setRound_description(String round_description) {
		this.round_description = round_description;
	}

}
