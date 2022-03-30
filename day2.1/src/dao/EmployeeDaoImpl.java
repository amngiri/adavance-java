package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pojos.Employee;
import static utils.DBUtils.openConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	// state : instance vars
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4,pst5;

	public EmployeeDaoImpl() throws SQLException {
		// get fix db connection from DBUtils
		cn = openConnection();
		pst1 = cn.prepareStatement(
				"select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?");
		pst2=cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		pst3=cn.prepareStatement("update my_emp set salary=salary+?,deptid=? where empid=?");
		pst4=cn.prepareStatement("delete from my_emp where empid=?");
		pst5=cn.prepareStatement("select deptid,avg(salary) from my_emp group by deptid");
		System.out.println("emp dao created...");
	}

	@Override
//	List<Employee> getSelectedEmpDetails(String dept,Date beginDate,Date endDate) throws SQLException;
	public List<Employee> getSelectedEmpDetails(String dept, Date beginDate, Date endDate) throws SQLException {
		List<Employee> emps=new ArrayList<>();
		// set IN params
		pst1.setString(1, dept);
		pst1.setDate(2, beginDate);
		pst1.setDate(3, endDate);
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
		}
		return emps;
	}
	
	
	
	@Override
	public String insertEmpDetails(Employee employee) throws SQLException {
//		String insertEmpDetails(Employee employee) throws SQLException;
		// set IN params
		//name    | addr    | salary | deptid | join_date
		pst2.setString(1,employee.getName());
		pst2.setString(2, employee.getAddress());
		pst2.setDouble(3,employee.getSalary());
		pst2.setString(4, employee.getDeptId());
		pst2.setDate(5, employee.getJoinDate());
		//exec the query : insert : DML : Method of PST : public int executeUpdate() throws SQLException
		int updateCount=pst2.executeUpdate();
		if(updateCount == 1)
			return "Emp details inserted ....";		
		return "Emp details insertion failed....";
	}
	

	@Override
	public String updateEmpDetails(int empId, double salIncr, String newDept) throws SQLException {
		// set IN params
		pst3.setDouble(1, salIncr);
		pst3.setString(2, newDept);
		pst3.setInt(3, empId);
		int updateCount=pst3.executeUpdate();
		if(updateCount == 1)
			return "Emp details updated ....";		
		return "Emp details updation failed....";
		
	}
	

	@Override
	public String deleteEmpDetails(int empId) throws SQLException {
		// set IN param : emp id
		pst4.setInt(1, empId);
		int updateCount=pst4.executeUpdate();
		if(updateCount == 1)
			return "Emp details deleted ....";		
		return "Emp details deletion failed....";
	}
	

	@Override
	public Map<String, Double> getAvgSalaryByDept() throws SQLException {
		Map<String, Double> map=new LinkedHashMap<>();
		try(ResultSet rst=pst5.executeQuery())
		{
			while(rst.next())
				map.put(rst.getString(1), rst.getDouble(2));
		}
		return map;
	}

	//add a method to clean up db resources
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		if(pst4 != null)
			pst4.close();
		if(pst5 != null)
			pst5.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up!");
	}

}
