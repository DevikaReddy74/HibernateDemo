package com.cts.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Course;

@Service
public interface CourseDao {

	public void addCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourseById(int id);
	public void deleteById(int id);
}
