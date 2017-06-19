package com.web.soulyogaadmin.course.action;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	@Action(value="getAllCourseList", results={@Result(name="ALLCOURSELIST", location="/course/courseQueryList.jsp")})
	public String getAllCourseList() {
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		CourseEntry courseCriteria = new CourseEntry();
		List<CourseEntry> templateList = courseService.getAllCourseList();
		
		if(UtilValidate.isNotEmpty(templateList))
		{
			session.setAttribute("course_list", templateList);
		}
		
		return "ALLCOURSELIST";

	}
	
}
