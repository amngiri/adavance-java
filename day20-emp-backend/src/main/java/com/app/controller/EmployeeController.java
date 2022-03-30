package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	// dependency : service layer i/f
	@Autowired
	private IEmployeeService employeeService;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method to send all emps to the caller(front end) :
	// getting resources : GET
	@GetMapping
	public ResponseEntity<?> getAllEmpDetails() {
		System.out.println("in get all emps");
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	// add request handling method to insert new emp detaild(create a new resource)
	// : POST
	@PostMapping
	public Employee addEmpDetails(@RequestBody @Valid   Employee e) // de-serial (un marshalling) + apply validation rules
	{

		System.out.println("in add emp " + e);
		return employeeService.addOrUpdateEmployeeDetails(e);
	}

	// add request handling method to delete emp details by emp id
	// Request URL sent by front end : http://host:port/api/employees/1234 ,
	// method=DELETE
	@DeleteMapping("/{id}")
	public String deleteEmpDetails(@PathVariable int id) {
		System.out.println("in del emp dtls " + id);
		return employeeService.deleteEmpDetails(id);
	}

	// add req handling method to get selected emp details by id.
	// URL : http://host:port/api/employees/1234 , method=GET
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmpDetails(@PathVariable int empId) {
		System.out.println("in get emp dtls " + empId);
	//	try {
			// invoke service layer's method
			return new ResponseEntity<>(employeeService.fetchEmpDetails(empId), HttpStatus.OK);
//		} catch (RuntimeException e) {
//			System.out.println("err in get emp dtls " + e);
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}

	}

	// add request handling method to update existing emp details (update a
	// resource) : PUT
	@PutMapping
	public Employee updateEmpDetails(@RequestBody @Valid  Employee e) // de-serial (un marshalling)
	{
		// e : DETACHED POJO , containing updated state
		System.out.println("in add emp " + e);
		return employeeService.addOrUpdateEmployeeDetails(e);
	}
	//add req handling method to find all emps drawing salary > specific value
	@GetMapping("/salary/{minSal}")
	public ResponseEntity<?> getAllEmpsBySalary(@PathVariable double minSal)
	{
		System.out.println("in get all emps by sal");
		//API of ResponseEntity
		//public static ResponseEntity ok(T body) : sets sts code=200 , with specified body content.
		return ResponseEntity.ok(employeeService.findEmpsBySalary(minSal));
	}

}
