package com.nacre.online_assesment.exception;

import javax.servlet.ServletException;

public class AssessmentPaperException extends ServletException
{
	private static final long serialVersionUID = 1L;
	public AssessmentPaperException(String s) 
	{
		super(s);
	}
}
