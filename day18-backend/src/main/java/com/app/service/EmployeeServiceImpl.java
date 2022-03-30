package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	// dependency : dao layer i/f
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		// Method of JpaRepository : super i/f dao layer i/f
		// Inherited API : public List<T> findAll();
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployeeDetails(Employee transientEmp) {
		// TODO Auto-generated method stub
		return employeeRepo.save(transientEmp);
	}// what will method ret ? DETACHED emp ---> to the controller

	@Override
	public String deleteEmpDetails(int id) {
		// service layer invokes dao's method
		employeeRepo.deleteById(id);
		return "Emp Details with ID" + id + "delete successfully";
	}
	
}
