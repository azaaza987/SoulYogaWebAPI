package com.web.soulyogaadmin.course.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.soulyogaadmin.course.dao.ICourseDao;
import com.web.soulyogaadmin.course.service.ICourseService;
import com.web.soulyogaadmin.entity.CourseEntry;


@Service("courseService")
@Transactional
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	private ICourseDao courseDao;
	
	@Override
	public List getAllCourseList(){
		List<CourseEntry> allCourseList = null;
		
		allCourseList = new ArrayList<CourseEntry>();
//		CourseEntry temp = new CourseEntry();
//		temp = new CourseEntry(1, "Yoba Basic", 1, 1, "Hello basic", 100, new Date(), new Date(), 0);
//		allCourseList.add(temp);
//		
//		temp = new CourseEntry(2, "Yoba Basic2", 2, 2, "Hello basic2", 200, new Date(), new Date(), 0);
//		allCourseList.add(temp);
//		
//		temp = new CourseEntry(1, "Yoba Basic", 3, 3, "Hello basic3", 300, new Date(), new Date(), 0);
//		allCourseList.add(temp);
		
		allCourseList = courseDao.getAllCourseList();
		
		return allCourseList;
	}


	@Override
	public List getSearchedCourseList(CourseEntry courseCriteria) {
		List<CourseEntry> searchedCourseList = courseDao.getSearchedCourseList(courseCriteria);
		return searchedCourseList;
	}
	
	
}
