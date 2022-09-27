package com.cts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@JsonManagedReference
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student",
				joinColumns = @JoinColumn(name="student_id"),
				inverseJoinColumns = @JoinColumn(name="course_id")
				)
	private List<Course> courses;

	public Student() {

	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	// adding the convenience methods for bi directional relationship between
	// student and course
	public void addCourses(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();

		}
		// bi directional link between teacher and course
		courses.add(course);
	}
}
