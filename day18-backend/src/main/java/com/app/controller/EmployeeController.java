package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	//dependency : service layer i/f
	@Autowired
	private IEmployeeService employeeService;
	
	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}
	//add request handling method to send all emps to the caller(front end) : getting resources : GET
	@GetMapping
	public List<Employee> getAllEmpDetails()
	{
		System.out.println("in get all emps");
		return employeeService.getAllEmployees();
	}
	//add request handling method to insert new emp detaild(create a new resource) : POST
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee e)
	{
		System.out.println("in add emp "+e);
		return employeeService.addEmployeeDetails(e);
	}
	//add request handaliing methid to delete emp dteails by empid
	//Request URL sent from front end:http://host:port/api/employee/1234,method=DELETE
	@DeleteMapping("/{id}")
	
		public String deleteEmpDetails(@PathVariable int id)
		{
			System.out.println("in empl dlts"+id);
			return employeeService.deleteEmpDetails(id);
		}
	//add request handaling method to collect selected emp details
	//URl:http://host:port/api/employee/1234,method=GET
//	@GetMapping("/{empId}")
//	public Employee getEmployeeDetails(@PathVariable int empId)
//	{
//		System.out.println("in empl dlts"+empId);
//		return employeefetc
//	}
}
