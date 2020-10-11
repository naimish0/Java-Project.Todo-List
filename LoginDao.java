import java.io.*;
import java.sql.*;
public class LoginDao {
public boolean validate(LoginBean loginBean) throws ClassNotFoundException
{
	boolean status=false;
	Class.forName("com.mysql.jdbc.Driver");
	try {
		Connection connection=JDBCUtils.getConnection();
		PreparedStatement preStmt=connection.prepareStatement("select *from users where username=? and password=?");
		preStmt.setString(1, loginBean.getUserName());
		preStmt.setString(2, loginBean.getPassword());
		System.out.println(preStmt);
		ResultSet rs=preStmt.executeQuery();
		status=rs.next();
	}
	catch(SQLException e)
	{
		JDBCUtils.printSQLException(e);
	}
	return status;
}
}
