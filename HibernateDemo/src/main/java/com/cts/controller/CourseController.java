package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Dao.CourseDao;
import com.cts.Dao.TeacherDao;
import com.cts.model.Course;
import com.cts.model.Teacher;

@RestController
public class CourseController {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private CourseDao courseDao;

	@RequestMapping("/addCourse")
	public void createCourse() {
		int id=2;
		Teacher teacher=teacherDao.getTeacherById(id);
		Course course=new Course("English");
		Course course2=new Course("Social");
		teacher.addCourse(course);
		teacher.addCourse(course2);
		courseDao.addCourse(course);
		courseDao.addCourse(course2);
		 
		
	}
	
	@RequestMapping("/getTeacherCourses/{id}")
	public List<Course> getCoursesByTeacherId(@PathVariable("id") int id) {
		Teacher teacher=teacherDao.getTeacherById(id);
		List<Course> courses = teacher.getCourses();
		return courses;
	}
	@RequestMapping("/getAllCourses")
	public List<Course> getCourses() {
		List<Course> courses = courseDao.getAllCourses();
		return courses;
	}
	
	
	@RequestMapping("/deleteCourseById/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		courseDao.deleteById(id);
		return "Deleted";
	}
	
}
