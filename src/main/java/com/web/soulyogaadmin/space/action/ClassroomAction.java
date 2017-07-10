package com.web.soulyogaadmin.space.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.soulyogaadmin.course.service.ICourseService;
import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.space.dao.IClassroomDao;
import com.web.soulyogaadmin.space.dao.IYogaclubDao;
import com.web.soulyogaadmin.space.service.ISpaceService;
import com.web.soulyogaadmin.util.UtilValidate;
import com.web.soulyogaadmin.vo.ClassroomYogacushionvo;

@ParentPackage(value = "struts-default")
@Namespace(value = "/")
public class ClassroomAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;

	private Classroom classroom;
	private String classroomNo;
	private int yogaCludId;

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public int getYogaCludId() {
		return yogaCludId;
	}

	public void setYogaCludId(int yogaCludId) {
		this.yogaCludId = yogaCludId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getClassName() {
		return className;
	}

	public static void setClassName(String className) {
		ClassroomAction.className = className;
	}

	private int id;
	private static String className = ClassroomAction.class.getName();

	private static Logger logger = Logger.getLogger(className);

	@Autowired
	private ICourseService courseService;

	@Autowired
	private ISpaceService spaceService;
	/*
	 * @OverrideyogaclubDao public CourseEntry getModel() { return courseEntry;
	 * }
	 */

	@SuppressWarnings("unchecked")
	@Action(value = "getClassroombyYogaclub", results = {
			@Result(name = "CLASSROOMQUERYSUCCESS", location = "/space/classroomQuerybyYogaclub.jsp") })
	public String getClassroombyYogaclub() {
		int id = Integer.parseInt(request.getParameter("id"));
		Yogaclub yogaclub = spaceService.getYogaclubbyId(id);
		List<ClassroomYogacushionvo> templateList = spaceService.getClassroombyYogaclub(id);
	

		if (UtilValidate.isNotEmpty(templateList)) {
			System.out.println(templateList.get(0).toString());
			request.setAttribute("classroomQuerybyYogaclub_list", templateList);
			return "CLASSROOMQUERYSUCCESS";

		}

		else {
			return "CLASSROOMQUERYSUCCESS";
		}
	}

	@SuppressWarnings("unchecked")
	@Action(value = "getAllClassroom", results = {
			@Result(name = "CLASSROOMQUERYSUCCESS", location = "/space/classroomQueryList.jsp") })
	public String getAllClassroom() {
		List<ClassroomYogacushionvo> templateList =  spaceService.getAllClassroom();
		if(UtilValidate.isNotEmpty(templateList)){
			request.setAttribute("AllClassroom_list",templateList);
		}
		return "CLASSROOMQUERYSUCCESS";

	}
	@SuppressWarnings("unchecked")
	@Action(value = "classroomAdd", results = {
			@Result(name = "CLASSROOMADDSUCCESS", location = "/space/classroomQueryList.jsp") })
	public String classroomAdd() {
	 String yogaClubId= ServletActionContext.getRequest().getParameter("allYogaclub");
	 System.out.println("当前查询的是"+yogaClubId);
     String yogaCushionCount=ServletActionContext.getRequest().getParameter("yogacushioncunt");		
	 String yogaClubName=spaceService.getYogaclubbyId(Integer.valueOf(yogaClubId)).getName();
     String yogaClubCount=  String.valueOf( spaceService.getClassroomCount(yogaCludId));
     Classroom classroom=new Classroom();
     classroom.setYogaCludId(Integer.valueOf(yogaClubId));
     classroom.setClassroomNo(yogaClubName+yogaClubCount);
     Date date =new Date();
     classroom.setCreatedTime(date);
     spaceService.addClassroom(classroom);
     return "CLASSROOMADDSUCCESS";

	}
	
	
	

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
