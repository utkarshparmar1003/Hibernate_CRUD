package com.profound.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int stud_id;
	
	@Column(name="Student_Name")
	private String stud_name;
	
	@Column(name="Student_City")
	private String stude_city;

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getStude_city() {
		return stude_city;
	}

	public void setStude_city(String stude_city) {
		this.stude_city = stude_city;
	}
	
}
