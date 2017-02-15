package com.nacre.online_assesment.form_bean;

import java.io.Serializable;

public class GradPostgradDetailsBean implements Serializable{

	/**
	 * @author praveen
	 */
	private static final long serialVersionUID = 1L;
	
	private String gradUnivesity;
	private String gradCollege;
	private String gradStream;
	private Integer gradYop;
	private Float gradPerc;
	
	private String postGradUnivesity;
	private String postGradCollege;
	private String postGradStream;
	private Integer postGradYop;
	private Float postGradPerc;
	
	
	public String getGradUnivesity() {
		return gradUnivesity;
	}
	public void setGradUnivesity(String gradUnivesity) {
		this.gradUnivesity = gradUnivesity;
	}
	public String getGradCollege() {
		return gradCollege;
	}
	public void setGradCollege(String gradCollege) {
		this.gradCollege = gradCollege;
	}
	public String getGradStream() {
		return gradStream;
	}
	public void setGradStream(String gradStream) {
		this.gradStream = gradStream;
	}
	public Integer getGradYop() {
		return gradYop;
	}
	public void setGradYop(Integer gradYop) {
		this.gradYop = gradYop;
	}
	public Float getGradPerc() {
		return gradPerc;
	}
	public void setGradPerc(Float gradPerc) {
		this.gradPerc = gradPerc;
	}
	public String getPostGradUnivesity() {
		return postGradUnivesity;
	}
	public void setPostGradUnivesity(String postGradUnivesity) {
		this.postGradUnivesity = postGradUnivesity;
	}
	public String getPostGradCollege() {
		return postGradCollege;
	}
	public void setPostGradCollege(String postGradCollege) {
		this.postGradCollege = postGradCollege;
	}
	public String getPostGradStream() {
		return postGradStream;
	}
	public void setPostGradStream(String postGradStream) {
		this.postGradStream = postGradStream;
	}
	public Integer getPostGradYop() {
		return postGradYop;
	}
	public void setPostGradYop(Integer postGradYop) {
		this.postGradYop = postGradYop;
	}
	public Float getPostGradPerc() {
		return postGradPerc;
	}
	public void setPostGradPerc(Float postGradPerc) {
		this.postGradPerc = postGradPerc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "GradPostgradDetailsBean [gradUnivesity=" + gradUnivesity
				+ ", gradCollege=" + gradCollege + ", gradStream=" + gradStream
				+ ", gradYop=" + gradYop + ", gradPerc=" + gradPerc
				+ ", postGradUnivesity=" + postGradUnivesity
				+ ", postGradCollege=" + postGradCollege + ", postGradStream="
				+ postGradStream + ", postGradYop=" + postGradYop
				+ ", postGradPerc=" + postGradPerc + "]";
	}
	
}
