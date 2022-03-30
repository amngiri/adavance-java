package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployees();
	Employee addEmployeeDetails(Employee transientEmp);
	String deleteEmpDetails(int id);
}
