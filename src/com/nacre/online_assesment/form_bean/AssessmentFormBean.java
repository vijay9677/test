package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.sql.Time;

public class AssessmentFormBean implements Serializable {
	/**@author  pavan pratap singh
	 * 
	 */
	private Integer assessmentId;
	private String assessmentName;
	private Integer assessmentMarks;
	private Integer assessmentDuration;
	private String assessmentDate;
	private String assessmentDescription;
	//private Integer assesmentTypeId;
	private String assessmentTypeName;
	//private Integer courseId;
	private String courseName;
	//private Integer levelId;
	private String levelName;
	private Integer no_of_students_for_a_slot;
	private Time start_time_of_slots;
	private Time end_time_slots;
	public Integer getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public Integer getAssessmentMarks() {
		return assessmentMarks;
	}
	public void setAssessmentMarks(Integer assessmentMarks) {
		this.assessmentMarks = assessmentMarks;
	}
	public Integer getAssessmentDuration() {
		return assessmentDuration;
	}
	public void setAssessmentDuration(Integer assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}
	public String getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public String getAssessmentDescription() {
		return assessmentDescription;
	}
	public void setAssessmentDescription(String assessmentDescription) {
		this.assessmentDescription = assessmentDescription;
	}
	public String getAssessmentTypeName() {
		return assessmentTypeName;
	}
	public void setAssessmentTypeName(String assessmentTypeName) {
		this.assessmentTypeName = assessmentTypeName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getNo_of_students_for_a_slot() {
		return no_of_students_for_a_slot;
	}
	public void setNo_of_students_for_a_slot(Integer no_of_students_for_a_slot) {
		this.no_of_students_for_a_slot = no_of_students_for_a_slot;
	}
	public Time getStart_time_of_slots() {
		return start_time_of_slots;
	}
	public void setStart_time_of_slots(Time start_time_of_slots) {
		this.start_time_of_slots = start_time_of_slots;
	}
	public Time getEnd_time_slots() {
		return end_time_slots;
	}
	public void setEnd_time_slots(Time end_time_slots) {
		this.end_time_slots = end_time_slots;
	}
	@Override
	public String toString() {
		return "AssessmentFormBean [assessmentId=" + assessmentId
				+ ", assessmentName=" + assessmentName + ", assessmentMarks="
				+ assessmentMarks + ", assessmentDuration="
				+ assessmentDuration + ", assessmentDate=" + assessmentDate
				+ ", assessmentDescription=" + assessmentDescription
				+ ", assessmentTypeName=" + assessmentTypeName
				+ ", courseName=" + courseName + ", levelName=" + levelName
				+ ", no_of_students_for_a_slot=" + no_of_students_for_a_slot
				+ ", start_time_of_slots=" + start_time_of_slots
				+ ", end_time_slots=" + end_time_slots + "]";
	}
	
}