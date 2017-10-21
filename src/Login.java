import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
	
	public static boolean LoginCheck(String username,String password) throws ClassNotFoundException
	{
		boolean userAvailable =false;
		
			Connection conn = ConnectionUtil.getConnectionUtil();
			PreparedStatement pst;
			try {
				pst = conn.prepareStatement("select username,userpassword from userdetails where username=? and userpassword=?");
				pst.setString(1, username);
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery(); 
				userAvailable = rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	       return userAvailable;
		
	}

}