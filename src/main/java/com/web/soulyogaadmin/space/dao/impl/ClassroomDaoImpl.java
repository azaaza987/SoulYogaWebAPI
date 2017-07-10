package com.web.soulyogaadmin.space.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.soulyogaadmin.course.dao.ICourseDao;
import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Yogacushion;
import com.web.soulyogaadmin.space.dao.IClassroomDao;
import com.web.soulyogaadmin.util.UtilValidate;
import com.web.soulyogaadmin.vo.ClassroomYogacushionvo;
import com.web.soulyogaadmin.vo.Yogacushionvo;

/**
 * Course Dao Implemention
 * 
 * @author Shawn Xiao
 * @version 2017-06-15
 */
@Repository("classroomDao")
@Transactional
public class ClassroomDaoImpl implements IClassroomDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	private static String className = ClassroomDaoImpl.class.getName();

	private static Logger logger = Logger.getLogger(className);

	public List<ClassroomYogacushionvo> getClassroombyYogaclub(int i) {

		String sql = null;
		session = this.sessionFactory.getCurrentSession();

		sql = "SELECT yogaclub.Name as yogaclubName,classroom.ClassroomNo as classroomNo,COUNT(yogacushion.YogaCushionNo) as YogaCushionCount FROM classroom LEFT JOIN yogacushion ON classroom.id = yogacushion.ClassroomID INNER JOIN yogaclub ON classroom.YogaCludID = yogaclub.ID where YogaCludID=? GROUP BY classroom.ClassroomNo ORDER BY yogaclub.Name , classroom.ClassroomNo";

		Query query = session.createSQLQuery(sql).addScalar("yogaclubName",StandardBasicTypes.STRING).addScalar("classroomNo",StandardBasicTypes.STRING).addScalar("YogaCushionCount",StandardBasicTypes.INTEGER)											
				.setResultTransformer(Transformers.aliasToBean(ClassroomYogacushionvo.class));
		query.setInteger(0, i);
		List<ClassroomYogacushionvo> list = query.list();
		System.out.println(list.size());
		if (list.size() > 0) {
			return list;
		} else {
			return null;

		}
	}

	@Override
	public List<ClassroomYogacushionvo> getAllClassroom() {
		// TODO Auto-generated method stub

		String sql = null;
		session = this.sessionFactory.getCurrentSession();

		sql = "SELECT yogaclub.Name as yogaclubName,classroom.ClassroomNo as classroomNo,COUNT(yogacushion.YogaCushionNo) as YogaCushionCount FROM classroom LEFT JOIN yogacushion ON classroom.id = yogacushion.ClassroomID INNER JOIN yogaclub ON classroom.YogaCludID = yogaclub.ID GROUP BY classroom.ClassroomNo ORDER BY yogaclub.Name , classroom.ClassroomNo";

		Query query = session.createSQLQuery(sql).addScalar("yogaclubName",StandardBasicTypes.STRING).addScalar("classroomNo",StandardBasicTypes.STRING).addScalar("YogaCushionCount",StandardBasicTypes.INTEGER)											
				.setResultTransformer(Transformers.aliasToBean(ClassroomYogacushionvo.class));
		List<ClassroomYogacushionvo> list = query.list();
          System.out.println(list.get(0));
		return list;

	}

	@Override
	public List<Yogacushionvo> getYogacushion() {
		// TODO Auto-generated method stub
		String sql = null;
		session = this.sessionFactory.getCurrentSession();

		sql = "select  ClassroomID as classroomNo, count(*) as yogachusionNo from yogacushion group by ClassroomID";

		Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Yogacushionvo.class));
		List<Yogacushionvo> list = query.list();

		return list;
	}

	@Override
	public void addClassroom(Classroom classroom) {
		 session = sessionFactory.getCurrentSession();
        session.save(classroom);
       
		System.out.println("添加会所成功会所成功"+  session.save(classroom));
        
       
	}
  public void addyogacushion(Yogacushion yogacushion){
	  
		 session = sessionFactory.getCurrentSession();
		 session.save(yogacushion);
	  
	  
	  
	  
  }

@Override
public char getClassroomCount(int yogaclubId) {
	 session = sessionFactory.getCurrentSession();

	String sql="select count(*) from classroom  where  YogaCludID=?";
	Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.TO_LIST);
    query.setInteger(0, yogaclubId);
	char count= (query.uniqueResult().toString().toCharArray())[1];
	System.out.println(count);
	return count;
}


}
