package com.web.soulyogaadmin.space.dao;

import java.util.List;

import com.web.soulyogaadmin.entity.Yogaclub;

public interface IYogaclubDao {
	public List<Yogaclub> getAllYogaclubList();
	public void deleteYogaclubbyId(int i);
    public Yogaclub getYogaclubbyId(int i);
    public void updateYogaclub(Yogaclub yogaclub);
    public void addYogaclub(Yogaclub yogaclub);
}
