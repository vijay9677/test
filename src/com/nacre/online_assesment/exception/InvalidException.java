package com.nacre.online_assesment.exception;

import java.sql.SQLException;

/**
 * @author B.Rakesh kumar
 * @InvalidException this class is used to throw the InvalidExceptionwhen the data received from 
 * the user in invalid 
 */
public class InvalidException extends Exception {
	
	public InvalidException()
	{
		
	}
	public InvalidException(String message)
	{
		super(message);
	}

}
