package com.web.soulyogaadmin.course.dao;

import java.util.List;

import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Coursecategory;
import com.web.soulyogaadmin.entity.Yogaclub;

/**
 * Course Dao Interface
 * @author Shawn xiao
 * @version 
 */
public interface ICourseDao {

	public List<CourseEntry> getAllCourseList();

	public List<CourseEntry> getSearchedCourseList(CourseEntry courseCriteria);
	
	public List<Yogaclub> getAllYogaclubList();
	
	public List<Coursecategory> getAllCoursecategoryList();
	
	public void courseAdd(CourseEntry course);
}
