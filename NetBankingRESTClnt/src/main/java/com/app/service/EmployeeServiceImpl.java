package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
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
		return employeeRepo.findAll();// tx over => sesison closed , rets List of detached entities to the caller
	}

	@Override
	public Employee addOrUpdateEmployeeDetails(Employee emp) {
		// emp.getId();
		// Employee e=new Employee(null, null, null);
		// TODO Auto-generated method stub
		return employeeRepo.save(emp);
		// CrudRepository Methd : save(T entity)
		// Checks if id == null => transient entity , will fire insert upon commit
		// if id != null => detached entity , will fire update upon commit
	}// what will method ret ? DETACHED emp ---> to the controller

	@Override
	public String deleteEmpDetails(int id) {
		// service layer invokes dao's method
		employeeRepo.deleteById(id);
		return "Emp Details with ID " + id + " deleted successfuly... ";
	}

	@Override
	public Employee fetchEmpDetails(int empId) {
		// invoke dao's method
		// Optional<Employee> optional = employeeRepo.findById(empId);
		return employeeRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Emp by ID " + empId + " not found!!!!"));
	}

	@Override
	public List<Employee> findEmpsBySalary(double minSal) {
		// TODO Auto-generated method stub
		// throw dummy exception to test global exc handler
		boolean flag=true;
		if (flag)
			throw new RuntimeException("Some dummy exception!!!!!!");
		return employeeRepo.findBySalaryGreaterThan(minSal);
	}

}
