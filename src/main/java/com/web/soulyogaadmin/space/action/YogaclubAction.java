package com.web.soulyogaadmin.space.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.soulyogaadmin.course.service.ICourseService;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.space.service.ISpaceService;
import com.web.soulyogaadmin.space.service.impl.SpaceServiceImpl;
import com.web.soulyogaadmin.util.UtilValidate;

@ParentPackage(value = "struts-default")
@Namespace(value = "/")
public class YogaclubAction extends ActionSupport implements ServletRequestAware , ServletResponseAware {
	private HttpServletRequest request;
	Yogaclub yogaclub = new Yogaclub();
	private HttpServletResponse response;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static String className = YogaclubAction.class.getName();

	private static Logger logger = Logger.getLogger(className);

	@Autowired
	private ISpaceService spaceService;

	@SuppressWarnings("unchecked")
	@Action(value = "getAllYogaclubList", results = {@Result(name = "ALLYOGACLUBLIST", location = "/space/yogaclubQueryList.jsp"), @Result(name="SELECTOPTIONYOGACLUBLIST",location="/space/classroomAdd.jsp") })
	public String getAllYogaclubList() {
            String header=request.getHeader("X-Requested-With");
            System.out.println(header);
            if(header==null){
            List<Yogaclub> templateList = spaceService.getAllYogaclub();
		    if (UtilValidate.isNotEmpty(templateList)) {
			System.out.println(11111);
			request.setAttribute("yogaclub_list", templateList);
			System.out.println(request.getAttribute("yogaclub_list"));

		}
		System.out.println(request.getAttribute("yogaclub_list"));
 
		return "ALLYOGACLUBLIST";
            }
            else{
            	 List<Yogaclub> templateList = spaceService.getAllYogaclub();
     		    if (UtilValidate.isNotEmpty(templateList)) {
     			System.out.println("AJAX查询成功");
                String json=JSONArray.toJSONString(templateList);
                System.out.println(json);
     			try {
     				ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8"); 

     				ServletActionContext.getResponse().getWriter().write(json);
     				return null;
     				
     			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     			
           	           	
            }
     		   String i="";
				return i ;
	
            }
	}
	@Action(value = "deleteYogaclubbyId", results = {
			@Result(name = "DELETESUCCESS", type="chain", location = "getAllYogaclubList") })

	public String deleteYogaclubbyId() {
		id = Integer.valueOf(request.getParameter("id"));
		spaceService.deleteYogaclubbyId(id);
		/*
		 * SpaceService.deleteYogaclubbyId(id);
		 */ return "DELETESUCCESS";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Action(value = "updateYogaclub", results = {@Result(name = "UPDATESUCCESS", location = "/space/yogaclubQueryList.jsp") })
   public String updateYogaclub(){
		try{
    String json=request.getParameter("citydata");
    System.out.println(json);
	 JSONObject yg=JSON.parseObject(json);
     Yogaclub yogaclub=new Yogaclub();
     yogaclub.setCity((String) yg.get("city"));
     yogaclub.setName((String) yg.get("name"));
     yogaclub.setAddress((String) yg.get("address"));
     yogaclub.setPhone((String) yg.get("phone"));
     yogaclub.setLinkman((String) yg.get("linkman"));
     yogaclub.setId((Integer) yg.get("id"));
     spaceService.updateYogaclub(yogaclub);
		}
		catch(Exception e){
			e.printStackTrace();
		}
     return "UPDATESUCCESS";
}
	@SuppressWarnings("unchecked")
	@Action(value = "getAllYogaclub", results = {
			@Result(name = "ALLYOGACLUBLIST", location = "/space/yogaclubQueryList.jsp") })
	public String addYogaclub() {
             String city=request.getParameter("city");
             String name=request.getParameter("name");
             String address=request.getParameter("address");
             String phone=request.getParameter("phone");
             String linkman=request.getParameter("linkman");
             Yogaclub yogaclub=new Yogaclub();
             yogaclub.setName(name);
             yogaclub.setAddress(address);
             yogaclub.setLinkman(linkman);
             yogaclub.setPhone(phone);
             yogaclub.setLinkman(linkman);
             yogaclub.setCity(city);
             yogaclub.setCreatedTime(new Date());
             spaceService.addYogaclub(yogaclub);
		return "ALLYOGACLUBLIST";

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

}
