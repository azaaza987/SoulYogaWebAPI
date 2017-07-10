package com.web.soulyogaadmin.course.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.soulyogaadmin.course.service.ICoursescheduleService;
import com.web.soulyogaadmin.entity.Courseschedule;

@ParentPackage(value="struts-default")
@Namespace(value="/")
public class CoursescheduleAction extends ActionSupport implements ModelDriven<Courseschedule>{
	Courseschedule courseschedule =new Courseschedule();
	private static String className = CourseAction.class.getName();

	private static Logger logger = Logger.getLogger(className);
@Autowired
ICoursescheduleService coursescheduleService;
	@Override
	public Courseschedule getModel() {
		// TODO Auto-generated method stub
		return courseschedule;
	}
	@Action(value="getAllCoursesecheduleList" ,results={@Result(name="AllCoursesecheduleList",location="/courseschedule/coursescheduleQueryList.jsp")})
	public String getAllCoursesecheduleList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Courseschedule>lists=coursescheduleService.getAllCourseschedules();
		if(lists!=null&&lists.size()>0){
			request.setAttribute("allCourseschedules_list", lists);
		}
		return "AllCoursesecheduleList";
		
	}
	@Action(value="getOneCoursesecheduleById" ,results={@Result(name="OneCoursesechedule",location="修改页面？？？")})
	public String getOneCoursesecheduleById(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("modifiedId");
		Courseschedule lists=coursescheduleService.getCoursescheduleById(Integer.parseInt(id));
		
			request.setAttribute("oneCourseschedule", lists);
		
		return "OneCoursesechedule";
		
	}
	@Action(value="getPartCoursesecheduleList",results={@Result(name="PartCoursesecheduleList",location="/courseschedule/coursescheduleQueryList.jsp")})
	public String getPartCoursesecheduleList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String teacherId=request.getParameter("teacherId");
		String classroomId=request.getParameter("classroomId");
		String courseId=request.getParameter("courseId");
		List<Courseschedule>lists=null;
		List<Courseschedule>lists1=null;
		List<Courseschedule>lists2=null;
		
		if((teacherId!=null&&!teacherId.equals(""))&&(classroomId!=null&&!classroomId.equals(""))&&(courseId!=null&&!courseId.equals(""))){
			lists=coursescheduleService.getCourseschedulesByTeacherId(Integer.parseInt(teacherId));
			lists1=coursescheduleService.getCourseschedulesByCourseId(Integer.parseInt(courseId));
			lists2=coursescheduleService.getCourseschedulesByClassroomId(Integer.parseInt(classroomId));
			lists.retainAll(lists1);
			lists.retainAll(lists2);
		}else if((teacherId==null||teacherId.equals(""))&&(classroomId!=null&&!classroomId.equals(""))&&(courseId!=null&&!courseId.equals(""))){		
			lists=coursescheduleService.getCourseschedulesByCourseId(Integer.parseInt(courseId));
			lists2=coursescheduleService.getCourseschedulesByClassroomId(Integer.parseInt(classroomId));
			lists.retainAll(lists2);
		}else if((teacherId!=null&&!teacherId.equals(""))&&(classroomId==null||classroomId.equals(""))&&(courseId!=null&&!courseId.equals(""))){
			lists=coursescheduleService.getCourseschedulesByTeacherId(Integer.parseInt(teacherId));
			lists1=coursescheduleService.getCourseschedulesByCourseId(Integer.parseInt(courseId));
			lists.retainAll(lists1);
		}else if((teacherId!=null&&!teacherId.equals(""))&&(classroomId!=null&&!classroomId.equals(""))&&(courseId==null||courseId.equals(""))){
			lists=coursescheduleService.getCourseschedulesByTeacherId(Integer.parseInt(teacherId));
			lists2=coursescheduleService.getCourseschedulesByClassroomId(Integer.parseInt(classroomId));
			lists.retainAll(lists2);
		}else if((teacherId==null||teacherId.equals(""))&&(classroomId==null||classroomId.equals(""))&&(courseId!=null&&!courseId.equals(""))){
			lists=coursescheduleService.getCourseschedulesByCourseId(Integer.parseInt(courseId));
		}else if((teacherId==null||teacherId.equals(""))&&(classroomId!=null&&!classroomId.equals(""))&&(courseId==null||courseId.equals(""))){

			lists=coursescheduleService.getCourseschedulesByClassroomId(Integer.parseInt(classroomId));
	
		}else if((teacherId!=null&&!teacherId.equals(""))&&(classroomId==null||classroomId.equals(""))&&(courseId==null||courseId.equals(""))){
			lists=coursescheduleService.getCourseschedulesByTeacherId(Integer.parseInt(teacherId));
		
		}else{
			lists=coursescheduleService.getAllCourseschedules();
		
		}
		
		if(lists!=null&&lists.size()>0){
			request.setAttribute("allCourseschedules_list", lists);
		}
		return "PartCoursesecheduleList";
		
	}
	@Action(value="deleteOneCourseshedule",results={@Result(name="deleteCourseshedule",type="chain",location="getAllCoursesecheduleList")})
	public String deleteOneCourseshedule(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("deleteCoursescheduleId");
		coursescheduleService.deleteCoursescheduleById(Integer.parseInt(id));
		return "deleteCourseshedule";
		
	}
	@Action(value="getTeacherId",results={@Result(name="TeacherId",location="/courseschedule/addNewCourseschedule.jsp")})
	public String getTeacherId() throws IOException{
		List<Integer> tids=coursescheduleService.getAllTeacherId();
		HttpServletResponse response =ServletActionContext.getResponse();
		HttpServletRequest request =ServletActionContext.getRequest();
//		System.out.println("=======================");
//		System.out.println(tids.get(0));
//		System.out.println("=======================");
//		System.out.println(tids.toString());
		//response.getWriter().print(tids);
		request.setAttribute("teacherIdlist", tids);
		return "TeacherId";
		
		
	}
	@Action(value="getCourseId")
	public void getCourseId() throws IOException{
		try {
		System.out.println("进入ajax方法");
		
		HttpServletResponse response =ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		String teacherId=request.getParameter("tid");
		System.out.println(teacherId);
		List<Integer> list =coursescheduleService.getAllCourseIdOfTeacherFromCourse(coursescheduleService.getAllcourseCategoryIDsFormTeacher(Integer.parseInt(teacherId)));
		System.out.println("12312312312312312312134123"+list);
		//String  jsonArray =  JSONArray.toJSONString(list);
		response.getWriter().print(list);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Action(value="getClassroomid")
	public void getClassroomid() throws IOException{
		HttpServletResponse response =ServletActionContext.getResponse();
		HttpServletRequest request =ServletActionContext.getRequest();
		
		String cId=request.getParameter("c_id");
		List<Integer>list=coursescheduleService.getAllClassroomIdOfCourse(Integer.parseInt(cId));
		System.out.println("===============");
		System.out.println(list);
		response.getWriter().print(list);
		//return "Classroomid";
		
		
	}
}
