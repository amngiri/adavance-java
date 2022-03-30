package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 20,unique = true)
	private String lastName;
	@Column(length = 30)
	private String location;
	@Column(length = 30)
	@JsonProperty("department")
	private String dept;
	private double salary;
	private LocalDate joinDate;
	public Employee(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	

//	public Employee() {
//		// TODO Auto-generated constructor stub
//	}

	public Employee(String name, String location, String dept) {
		super();
		this.name = name;
		this.location = location;
		this.dept = dept;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public String getDept() {
//		return dept;
//	}
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee Id " + getId() + " [name=" + name + ", location=" + location + ", dept=" + dept + "]";
//	}

}
