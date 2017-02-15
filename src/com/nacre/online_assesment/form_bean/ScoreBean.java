/**
 * 
 */
package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

/**
 * @author ashish
 *
 */
public class ScoreBean implements Serializable {
	
	private int attemptno;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String Image;
	private int marks;
	private String technology;
	private String course;
	private String assessmentName;
	private Integer totalMarks;
	
	public int getAttemptno() {
		return attemptno;
	}
	public void setAttemptno(int attemptno) {
		this.attemptno = attemptno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "ScoreBean [attemptno=" + attemptno + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobileNo=" + mobileNo + ", marks=" + marks + ", technology="
				+ technology + ", course=" + course + ", assessmentName=" + assessmentName + ", totalMarks="
				+ totalMarks + "]";
	}
	
}
