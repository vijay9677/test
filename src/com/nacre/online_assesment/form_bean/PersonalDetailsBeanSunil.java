package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @author sunil
 *
 */
public class PersonalDetailsBeanSunil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String mobileNo;
	private Date dob;
	private Integer gender;
	private String image;
	private Integer country;
	private Integer state;
	private Integer city;
	private String location;
	private Integer pin;

	/**
	 * 
	 * @return firstNmae
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * 
	 * @param firstname
	 *            to set fiestName
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * 
	 * @return lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * 
	 * @param lastname
	 *            to set lastName
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            to set email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            to set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * 
	 * @param mobileNo
	 *            set mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * 
	 * @return dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * 
	 * @param dob to set dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
/**
 * 
 * @return gender
 */
	public Integer getGender() {
		return gender;
	}
/**
 * 
 * @param gender to set gender
 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
/**
 * 
 * @return image in String
 */
	public String getImage() {
		return image;
	}
/**
 * 
 * @param image to set image
 */
	public void setImage(String image) {
		this.image = image;
	}

public Integer getCountry() {
	return country;
}

public void setCountry(Integer country) {
	this.country = country;
}

public Integer getState() {
	return state;
}

public void setState(Integer state) {
	this.state = state;
}

public Integer getCity() {
	return city;
}

public void setCity(Integer city) {
	this.city = city;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Integer getPin() {
	return pin;
}

public void setPin(Integer pin) {
	this.pin = pin;
}

@Override
public String toString() {
	return "PersonalDetailsBean [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
			+ password + ", mobileNo=" + mobileNo + ", dob=" + dob + ", gender=" + gender 
			+ ", country=" + country + ", state=" + state + ", city=" + city + ", location=" + location + ", pin=" + pin
			+ "]";
}


}
