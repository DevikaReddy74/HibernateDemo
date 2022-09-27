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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

//	OneToMany Bi directional between course and teacher
//	By adding "@JsonManagedReference" in teacher class and
//	"@JsonBackReference" in course class stops looping
	@JsonManagedReference
	@OneToMany(mappedBy = "teacher",
				cascade = { CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Course> courses;

	public Teacher() {

	}

	public Teacher(String firstName, String lastName, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	// adding the convenience methods for bi directional relationship between
	// teacher and course
	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();

		}
		// bi directional link between teacher and course
		courses.add(course);
		course.setTeacher(this);
	}

}
