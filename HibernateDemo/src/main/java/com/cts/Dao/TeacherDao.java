package com.cts.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Teacher;

@Service
public interface TeacherDao {

	public void addTeacher(Teacher teacher);
	public List<Teacher> getAllTeacher();
	public Teacher getTeacherById(int id);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(int id);
}
