package com.web.soulyogaadmin.space.service;

import java.util.List;

import com.web.soulyogaadmin.entity.Classroom;
import com.web.soulyogaadmin.entity.Yogaclub;
import com.web.soulyogaadmin.vo.ClassroomYogacushionvo;

public interface ISpaceService {
	public List getAllYogaclub();
    public void deleteYogaclubbyId(int i);
    public void updateYogaclub(Yogaclub yogaclub);
    public void addYogaclub(Yogaclub yogaclub);
    public List<ClassroomYogacushionvo> getClassroombyYogaclub(int i);
    public Yogaclub getYogaclubbyId(int i);
    public List<ClassroomYogacushionvo> getAllClassroom();
    public void addClassroom(Classroom classroom);
    public char getClassroomCount(int yogaclubId);
}
