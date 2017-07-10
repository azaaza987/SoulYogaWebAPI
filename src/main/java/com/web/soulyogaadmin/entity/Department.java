package com.web.soulyogaadmin.entity;
// Generated 2017-6-21 14:32:25 by Hibernate Tools 5.2.3.Final

import java.util.Date;

/**
 * Department generated by hbm2java
 */
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Date createdTime;
	private Date modifiedTime;
	private int state;

	public Department() {
	}

	public Department(Date createdTime, int state) {
		this.createdTime = createdTime;
		this.state = state;
	}

	public Department(String name, Date createdTime, Date modifiedTime, int state) {
		this.name = name;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.state = state;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}