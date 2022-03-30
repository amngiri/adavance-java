package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
	@NotEmpty(message ="First Name can't be blank")
	@Length(min = 4,max=20,message = "Invalid First Name length!!!!")
	@Column(length = 30)
	private String name;
	@Column(length = 20,unique = true)
	@NotEmpty(message ="Last Name can't be blank")
	@Length(min = 4,max=20,message = "Invalid Last Name length!!!!")	
	private String lastName;
	@Column(length = 30)
	@NotEmpty(message="location must be supplied")
	private String location;
	@Column(length = 30)
	@NotEmpty(message="department must be supplied")
	@JsonProperty("department")
	private String dept;
	@NotNull(message = "salary must be supplied")
	@Min(value = 10000, message="salary < min salary")
	@Max(value=50000, message="salary > max salary")
	private double salary;
	@Future(message = "Join Date must be in future....")
	private LocalDate joinDate;
	public Employee(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	

//	public Employee() {
//		// TODO Auto-generated constructor stub
//	}

//	public Employee(String name, String location, String dept) {
//		super();
//		this.name = name;
//		this.location = location;
//		this.dept = dept;
//	}

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
