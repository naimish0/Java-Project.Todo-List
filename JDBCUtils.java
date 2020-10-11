import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.*;

public class JDBCUtils {
private static String jdbcURL="jdbc:mysql://localhost:3306/demo";
private static String jdbcUser_Name="root";
private static String jdbc_Pass="root";
public static Connection getConnection()
{
	Connection connection =null;
	try
	{
	try {
		Class.forName("com.mydql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	connection=DriverManager.getConnection(jdbcURL,jdbcUser_Name,jdbc_Pass);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return connection;
}

public static void printSQLException(SQLException ex)
{
	for(Throwable e:ex)
	{
		if(e instanceof SQLException)
		{
			e.printStackTrace(System.err);
			System.err.println("SQLState:"+((SQLException)e).getSQLState());
			System.err.println("Error Code:"+((SQLException)e).getErrorCode());
			System.err.println("Message:" +e.getCause());
			Throwable t=ex.getCause();
			while(t!=null) {
				System.out.println("Cause: "+t);
				t=t.getCause();
			}
		}
		
	}
}
public static Date getSQLDate(LocalDate date)
{
	return java.sql.Date.valueOf(date);
}
public static LocalDate getUtilDate(Date sqlDate)
{
return sqlDate.toLocalDate();
}
}