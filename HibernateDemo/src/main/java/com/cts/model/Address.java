package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private int id;

	@Column(name = "d_no")
	private String dNo;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;
	
////	we are making the bi directional relationship b/w teacher and address
////	by adding teacher field here and adding one-one relation and adding setters and getters
////	By adding this we can get the teacher details by using address class
////	In this project i did not implement this get teacher details by using address class
//	
//	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//	private Teacher teacher;
//	
//	public Teacher getTeacher() {
//		return teacher;
//	}
//	
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}

	public Address() {
		
	}  
	
	public Address(String dNo, String city, String state) {
		this.dNo = dNo;
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", dNo=" + dNo + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
