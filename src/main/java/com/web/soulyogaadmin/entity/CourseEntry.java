package com.web.soulyogaadmin.entity;

import java.util.Date;

/**
 * Client generated by hbm2java
 */
public class CourseEntry implements java.io.Serializable {

	private int iD;

	private String name;
	
	private int courseCategoryID;
	
	private int yogaClubID;
	
	private String introduction;
	
	private int point;
	
	private String createdTime;
	
	private String modifiedTime;
	
	private int state;
	
	
	public CourseEntry() {
	}


	public CourseEntry(int iD, String name, int courseCategoryID, int yogaClubID, String introduction, int point,
			String createdTime, String modifiedTime, int state) {
		this.iD = iD;
		this.name = name;
		this.courseCategoryID = courseCategoryID;
		this.yogaClubID = yogaClubID;
		this.introduction = introduction;
		this.point = point;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.state = state;
	}


	public int getiD() {
		return iD;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCourseCategoryID() {
		return courseCategoryID;
	}


	public void setCourseCategoryID(int courseCategoryID) {
		this.courseCategoryID = courseCategoryID;
	}


	public int getYogaClubID() {
		return yogaClubID;
	}


	public void setYogaClubID(int yogaClubID) {
		this.yogaClubID = yogaClubID;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}

	public String getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}


	public String getModifiedTime() {
		return modifiedTime;
	}


	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	

}