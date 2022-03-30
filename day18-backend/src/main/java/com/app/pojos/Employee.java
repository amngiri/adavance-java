package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@Entity
@Table(name="employees")
public class Employee extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String location;
	@Column(length = 30)
	@JsonProperty("department")
	private String dept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "Employee Id " + getId() + " [name=" + name + ", location=" + location + ", dept=" + dept + "]";
	}

}
