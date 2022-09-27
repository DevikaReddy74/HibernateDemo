package com.cts.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Student;
import com.cts.repository.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao {

	@Autowired 
	private StudentRepository studentRepository;
	
	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> getAllstudent() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}


}
