package com.nacre.online_assesment.form_bean;


public class AdminUploadBean 
 {

	private String userName;
	private Long mobileNo;
	private String emailId;
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public Long getMobileNo() 
	{
		return mobileNo;
	}
	public void setMobileNo(Long mobileNumber) 
	{
		this.mobileNo = mobileNumber;
	}
	public String getEmailId() 
	{
		return emailId;
	}
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
}
