package com.nacre.online_assesment.form_bean;





/**
 * @ author Amarendar Guthuru
 *This FeedbackTypeBean class is created setting values to the respected values
 * So we can access this values through out the application by getter methods
 */



public class FeedbackTypeBean {
	public Integer feedbackid;

	/**
	 * @return the feedbackid
	 */
	public Integer getFeedbackid() {
		return feedbackid;
	}

	/**
	 * @param feedbackid the feedbackid to set
	 */
	public void setFeedbackid(Integer feedbackid) {
		this.feedbackid = feedbackid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedbackTypeBean [feedbackid=" + feedbackid + "]";
	}
	

}
