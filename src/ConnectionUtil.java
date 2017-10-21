import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	public static Connection getConnectionUtil() throws ClassNotFoundException
	{
	
			Class.forName("com.mysql.jdbc.Driver");
			 String url = "jdbc:mysql://localhost:3306/smartupgraders";
	           String dbusername = "root";
	           String dbpassword = "jothibasu";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, dbusername, dbpassword);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return conn;
	}
}