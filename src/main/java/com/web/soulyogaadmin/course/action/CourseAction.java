package com.web.soulyogaadmin.course.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.soulyogaadmin.course.service.ICourseService;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Coursecategory;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.util.UtilValidate;

@ParentPackage(value="struts-default")
@Namespace(value="/")
public class CourseAction extends ActionSupport implements ModelDriven<CourseEntry>{
	
	CourseEntry courseEntry = new CourseEntry();
	
	private static String className = CourseAction.class.getName();

	private static Logger logger = Logger.getLogger(className);

	@Autowired 
	private ICourseService courseService;
	 
	@Override
	public CourseEntry getModel() {
		return courseEntry;
	}
	
	private CourseEntry course;
	
	
	public CourseEntry getCourse() {
		return course;
	}


	public void setCourse(CourseEntry course) {
		this.course = course;
	}

	@SuppressWarnings("unchecked")
	@Action(value="getAllCourseList", results={@Result(name="ALLCOURSELIST", location="/course/courseQueryList.jsp")})
	public String getAllCourseList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		List<CourseEntry> templateList = courseService.getAllCourseList();
		
		if(UtilValidate.isNotEmpty(templateList))
		{
			request.setAttribute("course_list", templateList);
		}
		
		return "ALLCOURSELIST";

	}
	@Action(value="addcourse", results={@Result(name="success", location="/course/courseadd.jsp")})
	public String addCourse() {
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Coursecategory> coursecategory =courseService.getAllCoursecategoryList();
		request.setAttribute("courseCategory", coursecategory);
		List<Yogaclub> yogaclub =courseService.getAllYogaclubList();
		request.setAttribute("yogaClub", yogaclub);
		return "success";
	}
	
	@Action(value="addcourseEntry", results={@Result(name="success",type="chain", location="getAllCourseList")})
	public String addCourseEntry() {
		course.setCreatedTime(new Date());
		course.setState(0);
		courseService.courseAdd(course);
		return "success";
	}
}
