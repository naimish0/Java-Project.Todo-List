import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class UserDao {
public int registerEmployee(User employee) throws ClassNotFoundException{
	String INSERT_USERS_SQL="insert into users"+"(first_name,last_name,username,password) values"+"(?,?,?,?);";
	int result=0;
	try
	{
		Connection connection =JDBCUtils.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
		preparedStatement.setString(1,employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getUserName());
		preparedStatement.setString(4, employee.getPassword());
		System.out.println(preparedStatement);
		result=preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		JDBCUtils.printSQLException(e);
	}
		return result;	
}
}
