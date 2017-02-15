/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.util.List;

import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.CommonServicei;
import com.nacre.online_assesment.service_i.service_impl.CommonServiceimpl;

/**
 * @author Vijay Kumar Reddy K
 *
 */

public class CommonDelegate {

	/**
	 * @author Vijay Kumar Reddy K
	 * @return List of CountryDTO CONTAINS COUNTRY INFORMATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Countries are not available
	 */
	public List<CountryDTO> getCountry() throws DatabaseException, DataNotFoundException {
		CommonServicei commonServicei = new CommonServiceimpl();
		return commonServicei.getCountry();
	}
	/**
	 * @author Vijay Kumar Reddy K
	 * @return List of CountryDTO CONTAINS COUNTRY INFORMATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Countries are not available
	 */
	public List<StateDTO> getState(Integer countryId) throws DatabaseException, DataNotFoundException {
		CommonServicei commonServicei = new CommonServiceimpl();
		return commonServicei.getState(countryId);
	}
	
	/**
	 * @author Vijay Kumar Reddy K
	 * @return List of CountryDTO CONTAINS COUNTRY INFORMATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Countries are not available
	 */
	public List<CityDTO> getcity(Integer stateId) throws DatabaseException, DataNotFoundException {
		CommonServicei commonServicei = new CommonServiceimpl();
		return commonServicei.getCity(stateId);
	}

	/**
	 * @author Saurabh Suman
	 * @return List of LevelDTO CONTAINS TYPE OF LEVEL INFORMATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Levels are not available
	 */
	public List<LevelDTO> getLevel() throws DatabaseException, DataNotFoundException {
		CommonServicei commonServicei = new CommonServiceimpl();
		return commonServicei.getLevel();
	}
	/**
	 * 
	 * @return
	 * @throws DatabaseException
	 * @throws DataNotFoundException
	 */
	public List<CityDTO> getJobPostcity() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		CommonServicei c = new CommonServiceimpl();
		return c.getJobPostcity();
	}
	/**
	 * 
	 * @return
	 * @throws DatabaseException
	 * @throws DataNotFoundException
	 */
	public List<ClientDTO> getJobPostCompany() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		CommonServicei c = new CommonServiceimpl();
		return c.getJobPostCompany();
	}
	public List<TechnologyDTO> getJobPostTechnology() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		CommonServicei c = new CommonServiceimpl();
		return c.getJobPostTechnology();
	}

	/**
	 *@author sunil Kumar Maharana 
	 * @param technologyId 
	 *@return List of CourseDTO contains courses w.r.t coressponding Technology
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Courses are not available
	 */
	
	public List<CourseDTO> getCourse(Integer technologyId) throws DatabaseException, DataNotFoundException{
		CommonServicei commonServicei = new CommonServiceimpl();
		return commonServicei.getCourse(technologyId);
		
	}

}
