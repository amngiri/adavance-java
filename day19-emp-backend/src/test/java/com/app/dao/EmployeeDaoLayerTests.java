package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;
import static java.time.LocalDate.parse;

@SpringBootTest //entire SC is up n running in debug mode.=> all spring beans(controllers,service, dao)
//can be autowired directly
class EmployeeDaoLayerTests {
	@Autowired
	private EmployeeRepository empRepo;
	

	@Test
	void testFindBySalaryGreaterThan() {
		List<Employee> list = empRepo.findBySalaryGreaterThan(30000);
		System.out.println(list);
		assertEquals(3,list.size());
	}
	@Test
	void testFindByJoinDateBetween()
	{
		List<Employee> list = empRepo.findByJoinDateBetween(parse("2020-02-01"), parse("2020-12-31"));
		System.out.println(list);
		assertEquals(3, list.size());
	}
	@Test
	void testFindByDeptAndLocation()
	{
		List<Employee> list = empRepo.findByDeptAndLocation("Accounts", "Mumbai");
		assertEquals("Kiran", list.get(0).getName());
		assertEquals("Riya123", list.get(1).getName());
	}
	@Test
	void testFindByLastName()
	{
		Optional<Employee> optional = empRepo.findByLastName("Shekh");
		assertEquals("Kiran", optional.get().getName());
	}
	@Test
	@Transactional
	@Rollback(value = false)
	void testUpdateEmpSalary()
	{
		assertEquals(1, empRepo.updateEmpSalary(1000, 2));
	}
	@Test
	void testGetEmpFullNamesByDept()
	{
		List<Employee> list = empRepo.getEmpFullNamesByDept("Accounts");
		list.forEach(System.out::println);
		assertEquals(2,list.size());
	}

}
