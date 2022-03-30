package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployees();
	Employee addOrUpdateEmployeeDetails(Employee transientEmp);
	String deleteEmpDetails(int id);
	Employee fetchEmpDetails(int empId);
	//Find all emps drawing salary > specific value
	List<Employee> findEmpsBySalary(double minSal);
}
