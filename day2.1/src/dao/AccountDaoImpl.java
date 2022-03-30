package dao;

import java.sql.*;
import java.sql.SQLException;
import static utils.DBUtils.openConnection;

public class AccountDaoImpl implements IAccountDao {
	private Connection cn;
	private CallableStatement cst1;
	
	public AccountDaoImpl() throws SQLException{
		//get db cn from DBUtils
		cn=openConnection();
		//cst1 : to represent invocation of a stored proc
		cst1=cn.prepareCall("{call transfer_funds(?,?,?,?,?)}");
		//register OUT params
		//API of CST public void registerOutParameter(int paramPos,int jdbcTYpe) throws SQLException
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("acct dao created...");
	}
	
	

	@Override
	public String transferFunds(int srcAcctNo, int destAcctNo, double amount) throws SQLException {
		// set IN params
		cst1.setInt(1, srcAcctNo);
		cst1.setInt(2,destAcctNo);
		cst1.setDouble(3, amount);
		//exec stored procedure
		cst1.execute();
		return "Updated Src Balance "+cst1.getDouble(4)+" Dest Balance "+cst1.getDouble(5);
	}
	//add a method to clean up db resources
	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
			cst1.close();
		if(cn != null)
			cn.close();
		System.out.println("acct dao closed...");
	}

}
