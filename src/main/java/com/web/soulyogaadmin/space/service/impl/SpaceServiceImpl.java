package com.web.soulyogaadmin.space.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.space.dao.IClassroomDao;
import com.web.soulyogaadmin.space.dao.IYogaclubDao;
import com.web.soulyogaadmin.space.service.ISpaceService;
import com.web.soulyogaadmin.vo.ClassroomYogacushionvo;
@Service("spaceService")
@Transactional
public class SpaceServiceImpl implements ISpaceService {
    @Autowired
	private IYogaclubDao yogaclubDao;
    @Autowired
    private IClassroomDao classroomDao;
	@Override
	public List getAllYogaclub() {
		// TODO Auto-generated method stub
      List<Yogaclub> allYogaclubList=null;
      allYogaclubList=  yogaclubDao.getAllYogaclubList();
	return allYogaclubList;
	
	}
	@Override
	public void deleteYogaclubbyId(int i) {
		yogaclubDao.deleteYogaclubbyId(i);
	}
	@Override
	public void updateYogaclub(Yogaclub yogaclub) {
		yogaclubDao.updateYogaclub(yogaclub);
		
	}
	@Override
	public void addYogaclub(Yogaclub yogaclub) {
		// TODO Auto-generated method stub
		yogaclubDao.addYogaclub(yogaclub);
	}
	@Override
	public List<ClassroomYogacushionvo> getClassroombyYogaclub(int i) {
		// TODO Auto-generated method stub
        		
		List<ClassroomYogacushionvo> templateList = (List<ClassroomYogacushionvo>) classroomDao.getClassroombyYogaclub(i);
	     System.out.println("space"+templateList.size());
		return templateList;
	}
	@Override
	public Yogaclub getYogaclubbyId(int i) {
		// TODO Auto-generated method stub
		Yogaclub yogaclub=yogaclubDao.getYogaclubbyId(i);
		return yogaclub;
	}
	@Override
	public List<ClassroomYogacushionvo> getAllClassroom() {
		List<ClassroomYogacushionvo> list= classroomDao.getAllClassroom();
	return	list;
	}
	@Override
	public void addClassroom(Classroom classroom) {
		classroomDao.addClassroom(classroom);
		
		
	
	}
    public char getClassroomCount(int yogaclubId){
    	 return classroomDao.getClassroomCount(yogaclubId);
    	
    }


}
