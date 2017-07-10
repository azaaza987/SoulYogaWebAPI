package com.web.soulyogaadmin.space.dao.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.soulyogaadmin.course.dao.ICourseDao;
import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.space.dao.IClassroomDao;
import com.web.soulyogaadmin.space.dao.IYogaclubDao;
import com.web.soulyogaadmin.util.UtilValidate;


/**
 * Course Dao Implemention
 * @author Shawn Xiao
 * @version 2017-06-15
 */
@Repository("yogaclubDao")
@Transactional
public class YogaclubDaoImpl implements IYogaclubDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	private static String className = YogaclubDaoImpl.class.getName();

	private static Logger logger = Logger.getLogger(className);
	

	public List getAllYogaclubList() {

		String hql = null;
		session = this.sessionFactory.getCurrentSession();

		hql = "from Yogaclub y where y.state=0 ";

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

		List<Yogaclub> list = query.list();

		if (list.size() > 0) {
			return list;
		}
		return null;
	}


	@Override
	public void deleteYogaclubbyId(int i) {
		session = this.sessionFactory.getCurrentSession();

	   Yogaclub yogaclub=getYogaclubbyId(i);
	   System.out.println(yogaclub.getId());
	   yogaclub.setState(1);
	   session.merge(yogaclub);
	   
		
	}


	@Override
	public Yogaclub getYogaclubbyId(int i) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Yogaclub where id=?"; 
		Query query = session.createQuery(hql);
        query.setInteger(0,i);
		Yogaclub yoga=(Yogaclub) query.uniqueResult();
		return yoga;
	}


	@Override
	public void updateYogaclub(Yogaclub yogaclub ) {
		Session session = sessionFactory.getCurrentSession();
		session.update(yogaclub);
		System.out.println("存储会所成功");
	}


	@Override
	public void addYogaclub(Yogaclub yogaclub) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
         session.save(yogaclub);        
 		System.out.println("添加会所成功会所成功"+  session.save(yogaclub));

	}

   

	
	
}
