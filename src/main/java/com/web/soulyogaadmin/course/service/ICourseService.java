package com.web.soulyogaadmin.course.service;

import java.util.List;

import com.web.soulyogaadmin.entity.CourseEntry;

public interface ICourseService {
	
	public List getAllCourseList();
	
	public List getSearchedCourseList(CourseEntry courseCriteria);
}
