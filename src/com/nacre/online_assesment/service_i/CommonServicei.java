/**
 * 
 */
package com.nacre.online_assesment.service_i;

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
public interface CommonServicei {

	/**
	 * @author Vijay Kumar Reddy K
	 * @return java.utol.List Contains CountryDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<CountryDTO> getCountry() throws DatabaseException , DataNotFoundException;
	/**
	 * @author Vijay Kumar Reddy K
	 * @return java.utol.List Contains CountryDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<StateDTO> getState(Integer countryId) throws DatabaseException , DataNotFoundException;
	/**
	 * @author Vijay Kumar Reddy K
	 * @return java.utol.List Contains CountryDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<CityDTO> getCity(Integer stateId) throws DatabaseException , DataNotFoundException;
	/**
	 * @author Saurabh Suman
	 * @return java.util.List Contains LevelDTO Objects
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Levels are not available
	 */
	public List<LevelDTO> getLevel() throws DatabaseException , DataNotFoundException;
/**
	
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains cityDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<CityDTO> getJobPostcity()throws DatabaseException , DataNotFoundException;
	
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains ClientDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<ClientDTO> getJobPostCompany()throws DatabaseException , DataNotFoundException;
	
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains TechnologyDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws DataNotFoundException occurs if no countries are available
	 */
	public List<TechnologyDTO> getJobPostTechnology()throws DatabaseException , DataNotFoundException;

	/**
	 *@author sunil Kumar Maharana 
	 * @param technologyId 
	 *@return List of CourseDTO contains courses w.r.t coressponding Technology
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Courses are not available
	 */
	
	public List<CourseDTO> getCourse(Integer technologyId) throws DatabaseException, DataNotFoundException;

}
