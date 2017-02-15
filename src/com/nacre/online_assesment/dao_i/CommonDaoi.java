/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.util.List;

import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface CommonDaoi {

	/**
	 * @author Vijay Kumar Reddy K
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Countrys
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CountryDTO> getCountryList(Connection con) throws DataNotFoundException, DatabaseException; 

	/**
	 * @author Vijay Kumar Reddy K
	 * @param con Accepts java.sql.Connection
	 * @param countryId accepts integer value of country
	 * @return List contains all States of inputed country
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<StateDTO> getStateList(Connection con,Integer countryId) throws DataNotFoundException, DatabaseException;
	
	/**
	 * @author Vijay Kumar Reddy K
	 * @param con Accepts java.sql.Connection
	 * @param stateId accepts integer value of state
	 * @return List contains all States of inputed country
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CityDTO> getCityList(Connection con,Integer stateId) throws DataNotFoundException, DatabaseException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all City object
	 * @throws DataNotFoundException occurs when no city is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CityDTO> getJobPostcity(Connection con)throws DataNotFoundException, DatabaseException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Client object
	 * @throws DataNotFoundException occurs when no client is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<ClientDTO> getJobPostCompany(Connection con)throws DataNotFoundException,DatabaseException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all technology object
	 * @throws DataNotFoundException occurs when no technology is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<TechnologyDTO> getJobPostTechnology(Connection con)throws DataNotFoundException,DatabaseException;
   
	/**
	 * @author Saurabh Suman
	 * @param con Accepts java.sql.Connection
	 * @param levelId accepts integer value of level
	 * @return java.util.List Contains LevelDTO Objects
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Levels are not available
	 */
	public List<LevelDTO> getLevelList(Connection con) throws DataNotFoundException,DatabaseException;
	

	/**
	 *@author sunil Kumar Maharana 
	 * @param technologyId 
	 *@param con Accepts java.sql.Connection
	 *@return List of CourseDTO contains courses w.r.t coressponding Technology
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Courses are not available
	 */
	
	public List<CourseDTO> getCourse(Integer technologyId, Connection con) throws DatabaseException, DataNotFoundException ;	
	
	
	
	
}
