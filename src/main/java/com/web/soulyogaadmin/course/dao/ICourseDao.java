package com.web.soulyogaadmin.course.dao;

import java.util.List;

import com.web.soulyogaadmin.entity.CourseEntry;

/**
 * Course Dao Interface
 * @author Shawn xiao
 * @version 
 */
public interface ICourseDao {

	public List<CourseEntry> getAllCourseList();

	public List<CourseEntry> getSearchedCourseList(CourseEntry courseCriteria);
}
