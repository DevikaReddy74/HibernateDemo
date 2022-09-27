package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Dao.CourseDao;
import com.cts.Dao.StudentDao;
import com.cts.model.Course;
import com.cts.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CourseDao courseDao;
	
	@RequestMapping("/addStudent")
	public String createCourseAndStudent() {
		int id=3;
		Course course=courseDao.getCourseById(id);
		Student student=new Student("Babu", "reddy");
		Student student2=new Student("Bablu", "reddy");
		course.addStudent(student);
		course.addStudent(student2);
		studentDao.addStudent(student);
		studentDao.addStudent(student2);
		return "Added";
	}
	@RequestMapping("/addCourses")
	public String createStudentAndCourse() {
		int id=1;
		Student student=studentDao.getStudentById(id); 
		Course course=new Course("Botony");
		Course course2=new Course("Zoology");
		student.addCourses(course);
		student.addCourses(course2);
		courseDao.addCourse(course);
		courseDao.addCourse(course2);
		return "Added";
	}	
	
	@RequestMapping("/getStudentCourses/{id}")
	public List<Course> getStudentCourses(@PathVariable("id") int id) {
		Student student=studentDao.getStudentById(id);
		List<Course> courses=student.getCourses();
		return courses;
		
	}
	@RequestMapping("/getCourseStudents/{id}")
	public List<Student> getCourseStudents(@PathVariable("id") int id) {
		Course course=courseDao.getCourseById(id);
		List<Student> students=course.getStudents();
		return students;
		
	}
	
	@RequestMapping("/deleteStudent")
	public void delete() {
		int id=3;
		studentDao.deleteStudent(id);
	}
	
	@RequestMapping("/deleteCourseid")
	public void deleteCourse() {
		int id=6;
		courseDao.deleteById(id);
	}
	

}
