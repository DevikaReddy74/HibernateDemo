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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@UniqueElements
	@Column(name = "title")
	private String title;

//	OneToMany Bi directional between course and teacher
//	By adding "@JsonManagedReference" in teacher class and
//	"@JsonBackReference" in course class stops looping
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

//	OneToMany uni directional between course and reviews
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	@JsonBackReference
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student",
				joinColumns = @JoinColumn(name="course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id")
				)
	private List<Student> students;

	public Course() {

	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	// adding the convenience methods for bi directional relationship between
	// course and review
	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();

		}
		// bi directional link between teacher and course
		reviews.add(review);
	}
	// adding the convenience methods for bi directional relationship between
	// course and student
	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();

		}
		// bi directional link between teacher and course
		students.add(student);
	}
}
