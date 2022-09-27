package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Dao.TeacherDao;
import com.cts.model.Address;
import com.cts.model.Teacher;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@RequestMapping("/home")
	public String saveTeacher() {
		Teacher teacher=new Teacher();
		teacher.setFirstName("Devika");
		teacher.setLastName("Reddy");
		teacher.setEmail("devika@gmail.com");
		Address address=new Address("9-5", "Dmm", "Andhra");
		teacher.setAddress(address);
		teacherDao.addTeacher(teacher);
//		System.out.println("Saved");
		return "Saved";
	}
	@RequestMapping("/getAll")
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = teacherDao.getAllTeacher();
//		for (Student student : student2) {
//			System.out.println(student);
//		}
		return teachers;
	}
	
	@RequestMapping("/getById/{id}")
	public Teacher getTeacher(@PathVariable("id") int id) {
		Teacher teacher = teacherDao.getTeacherById(id);
		return teacher;
	}
	
	
	@RequestMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable("id") int id) {
		teacherDao.deleteTeacher(id);
	}
	
}
