package com.web.soulyogaadmin.space.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.CourseEntry;
import com.web.soulyogaadmin.entity.Yogacushion;
import com.web.soulyogaadmin.vo.ClassroomYogacushionvo;
import com.web.soulyogaadmin.vo.Yogacushionvo;

/**
 * Course Dao Interface
 * @author Shawn xiao
 * @version 
 */
/*@Repository(value="classroomDao")*/
public interface IClassroomDao {

	public List<ClassroomYogacushionvo> getClassroombyYogaclub( int i);
    public List<ClassroomYogacushionvo> getAllClassroom();
    public List<Yogacushionvo> getYogacushion();
    public void addClassroom(Classroom classroom);
    public void addyogacushion(Yogacushion yogacushion);
    public char getClassroomCount(int yogaclubId);
}
