package com.cts.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Teacher;
import com.cts.repository.TeacherRepository;

@Service
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public void addTeacher(Teacher teacher) {
		
		teacherRepository.save(teacher);

	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> teachers = teacherRepository.findAll();
		return teachers;
	}

	@Override
	public Teacher getTeacherById(int id) {
		Teacher teacher=teacherRepository.findById(id).get();
		return teacher;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(int id) {
		teacherRepository.deleteById(id);
	}

}
