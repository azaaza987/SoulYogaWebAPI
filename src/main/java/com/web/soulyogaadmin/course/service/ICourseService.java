package com.web.soulyogaadmin.course.service;

import java.util.List;

import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Coursecategory;
import com.web.soulyogaadmin.entity.Yogaclub;

public interface ICourseService {
	
	public List getAllCourseList();
	
	public List getSearchedCourseList(CourseEntry courseCriteria);
	
	public List<Yogaclub> getAllYogaclubList();
	
	public List<Coursecategory> getAllCoursecategoryList();
	
    void courseAdd(CourseEntry course);
}
