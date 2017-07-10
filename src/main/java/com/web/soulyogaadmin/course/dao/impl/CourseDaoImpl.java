package com.web.soulyogaadmin.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.soulyogaadmin.course.dao.ICourseDao;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Coursecategory;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.util.UtilValidate;


/**
 * Course Dao Implemention
 * @author Shawn Xiao
 * @version 2017-06-15
 */
@Repository("courseDao")
@Transactional
public class CourseDaoImpl implements ICourseDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	private static String className = CourseDaoImpl.class.getName();

	private static Logger logger = Logger.getLogger(className);
	

	public List getAllCourseList() {

		String hql = null;
		session = this.sessionFactory.getCurrentSession();

		hql = "from CourseEntry m where 1=1 ";

		Query query = session.createQuery(hql);

//		if ("All".equals(templateId) && !"All".equals(channel)) {
//			query.setParameter(0, channel);
//		} else if (!"All".equals(templateId)
//				&& ("All".equals(channel))) {
//			query.setParameter(0, templateId);
//		} else if (!"All".equals(templateId)
//				&& !"All".equals(channel)) {
//			query.setParameter(0, templateId);
//			query.setParameter(1, channel);
//		}

		List<CourseEntry> list = query.list();

		if (list.size() > 0) {
			return list;
		}
		return null;
	}


	@Override
	public List<CourseEntry> getSearchedCourseList(CourseEntry courseCriteria) {
		String hql = null;
		session = this.sessionFactory.getCurrentSession();
		
		hql = "from CourseEntry m where 1=1 ";
		
		if(UtilValidate.isNotEmpty(courseCriteria) && UtilValidate.isNotEmpty(courseCriteria.getCourseCategoryID())){
			hql += " and courseCategoryID = ?";
		}
			
		Query query = session.createQuery(hql);

		if(UtilValidate.isNotEmpty(courseCriteria) && UtilValidate.isNotEmpty(courseCriteria.getCourseCategoryID())){
			query.setParameter(0, courseCriteria.getCourseCategoryID());
		}

		List<CourseEntry> list = query.list();

		if (list.size() > 0) {
			return list;
		}
		return null;
	}


	@Override
	public List<Yogaclub> getAllYogaclubList() {
		List<Yogaclub> list=new ArrayList<Yogaclub>();
		session = this.sessionFactory.getCurrentSession();
		String hql="from Yogaclub y where y.state=0 ";
		Query query = session.createQuery(hql);
		list=query.list();
		return list;
	}


	@Override
	public List<Coursecategory> getAllCoursecategoryList() {
		List<Coursecategory> list=new ArrayList<Coursecategory>();
		session=this.sessionFactory.getCurrentSession();
		String hql="from Coursecategory c where c.state=0 ";
		Query query=session.createQuery(hql);
		list=query.list();
		return list;
	}


	@Override
	public void courseAdd(CourseEntry course) {
		session =this.sessionFactory.getCurrentSession();
		session.save(course);
	}



	
	
}
