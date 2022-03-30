package dao;
import java.sql.SQLException;

import pojos.User;
public interface IUserDao {
User authenticateUser(String name,int password) throws SQLException;
}
