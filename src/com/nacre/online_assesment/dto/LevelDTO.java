/**
 * 
 */
package com.nacre.online_assesment.dto;

import java.io.Serializable;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class LevelDTO implements Serializable {

	/**
	 * 
	 */
	public LevelDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer levelId;
	private String level;
	/**
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}
	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LevelDTO [levelId=" + levelId + ", level=" + level + "]";
	}
	
	

}
