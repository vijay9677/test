package com.nacre.online_assesment.vo;
import java.io.Serializable;
/**
 * @author Manish kumar deo
 *
 */
import java.util.Date;

public class AssessmentNotification  implements Serializable{
private Integer assessment_id;
private String assessment_name;
private Integer total_marks;
private Integer duration_in_min;
private Date date;
private String course;
private String assessment_type_name;
private Integer userId;

@Override
public String toString() {
	return "AssessmentNotification [assessment_id=" + assessment_id
			+ ", assessment_name=" + assessment_name + ", total_marks="
			+ total_marks + ", duration_in_min=" + duration_in_min + ", date="
			+ date + ", course=" + course + ", assessment_type_name="
			+ assessment_type_name + ", userId=" + userId + "]";
}
/**
 * @return the Assessment_id
 */
public Integer getAssessment_id() {
	return assessment_id;
}
/**
 * @param assessment_id the assessment_id to set
 */
public void setAssessment_id(Integer assessment_id) {
	this.assessment_id = assessment_id;
}
/**
 * @return the Assessment_name
 */
public String getAssessment_name() {
	return assessment_name;
}
/**
 * @param assessment_name the assessment_name to set
 */
public void setAssessment_name(String assessment_name) {
	this.assessment_name = assessment_name;
}
/**
 * @return the Total_marks
 */
public Integer getTotal_marks() {
	return total_marks;
}
/**
 * @param total_marks the total_marks to set
 */
public void setTotal_marks(Integer total_marks) {
	this.total_marks = total_marks;
}
/**
 * @return the Duration_in_min
 */
public Integer getDuration_in_min() {
	return duration_in_min;
}
/**
 * @param duration_in_min the duration_in_min to set
 */
public void setDuration_in_min(Integer duration_in_min) {
	this.duration_in_min = duration_in_min;
}
/**
 * @return the Date
 */
public Date getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}
/**
 * @return the course
 */
public String getCourse() {
	return course;
}
/**
 * @param course the course to set
 */
public void setCourse(String course) {
	this.course = course;
}
/**
 * @return the Assessment_type_name
 */
public String getAssessment_type_name() {
	return assessment_type_name;
}
/**
 * @param Assessment_type_name the Assessment_type_name to set
 */
public void setAssessment_type_name(String assessment_type_name) {
	this.assessment_type_name = assessment_type_name;
}
/**
 * @return the userId
 */
public Integer getUserId() {
	return userId;
}
/**
 * @param userId the userId to set
 */
public void setUserId(Integer userId) {
	this.userId = userId;
}

}
