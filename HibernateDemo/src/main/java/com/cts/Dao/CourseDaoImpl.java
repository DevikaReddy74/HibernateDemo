package com.cts.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Course;
import com.cts.repository.CourseRepository;

@Service
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}
	

	@Override
	public Course getCourseById(int id) {
		Course course = courseRepository.findById(id).get();
		return course;
	}

	@Override
	public void deleteById(int id) {
		courseRepository.deleteById(id);
		
	}

}
