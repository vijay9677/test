package com.nacre.online_assesment.form_bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author sunil
 *
 */
public class TechnologyCoursesDetailsBean implements Serializable{
private Integer technologyId;
private List<Integer> coursesIdList;
public Integer getTechnologyId() {
	return technologyId;
}
public void setTechnologyId(Integer technologyId) {
	this.technologyId = technologyId;
}
public List<Integer> getCoursesIdList() {
	return coursesIdList;
}
public void setCoursesIdList(List<Integer> coursesIdList) {
	this.coursesIdList = coursesIdList;
}
@Override
public String toString() {
	return "TechnologyCoursesDetailsBean [technologyId=" + technologyId + ", coursesIdList=" + coursesIdList + "]";
}



}
