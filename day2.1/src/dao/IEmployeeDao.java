package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pojos.Employee;

public interface IEmployeeDao {
	/*
	 * Display details(id,name,salary,join date) of all emps from a specific dept ,
	 * joined between strt date n end date
	 */
	List<Employee> getSelectedEmpDetails(String dept,Date beginDate,Date endDate) throws SQLException;
	//add a method to insert new emp details
	String insertEmpDetails(Employee employee) throws SQLException;
	//add a method to update emp's dept n salary
	String updateEmpDetails(int empId,double salIncr,String newDept) throws SQLException;
	//add a method to delete emp details
	String deleteEmpDetails(int empId) throws SQLException;
	//add a method to get dept wise avg salary of the emps
	Map<String,Double> getAvgSalaryByDept() throws SQLException;
}
