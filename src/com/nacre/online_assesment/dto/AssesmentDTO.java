/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AssesmentDTO implements Serializable {

	/**
	 * 
	 */
	public AssesmentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer assesmentId;
	private String assesment;
	private Integer totalMarks;
	private Integer durationInMin;
	private Date date;
	private String description;
	private AssesmentTypeDTO assesmentType;
	private CourseDTO course;
	private LevelDTO level;
	private Integer NoOfStudentsForaSlot;
	private Time StartTime;
	private Time EndTime;
	public Integer getAssesmentId() {
		return assesmentId;
	}
	public void setAssesmentId(Integer assesmentId) {
		this.assesmentId = assesmentId;
	}
	public String getAssesment() {
		return assesment;
	}
	public void setAssesment(String assesment) {
		this.assesment = assesment;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	public Integer getDurationInMin() {
		return durationInMin;
	}
	public void setDurationInMin(Integer durationInMin) {
		this.durationInMin = durationInMin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AssesmentTypeDTO getAssesmentType() {
		return assesmentType;
	}
	public void setAssesmentType(AssesmentTypeDTO assesmentType) {
		this.assesmentType = assesmentType;
	}
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	public LevelDTO getLevel() {
		return level;
	}
	public void setLevel(LevelDTO level) {
		this.level = level;
	}
	public Integer getNoOfStudentsForaSlot() {
		return NoOfStudentsForaSlot;
	}
	public void setNoOfStudentsForaSlot(Integer noOfStudentsForaSlot) {
		NoOfStudentsForaSlot = noOfStudentsForaSlot;
	}
	public Time getStartTime() {
		return StartTime;
	}
	public void setStartTime(Time startTime) {
		StartTime = startTime;
	}
	public Time getEndTime() {
		return EndTime;
	}
	public void setEndTime(Time endTime) {
		EndTime = endTime;
	}
	@Override
	public String toString() {
		return "AssesmentDTO [assesmentId=" + assesmentId + ", assesment="
				+ assesment + ", totalMarks=" + totalMarks + ", durationInMin="
				+ durationInMin + ", date=" + date + ", description="
				+ description + ", assesmentType=" + assesmentType
				+ ", course=" + course + ", level=" + level
				+ ", NoOfStudentsForaSlot=" + NoOfStudentsForaSlot
				+ ", StartTime=" + StartTime + ", EndTime=" + EndTime + "]";
	}
	
	
	
	

}
