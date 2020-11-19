package config;
import java.sql.*;

public class JDBCConnection {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		String url= "jdbc:mysql://localhost:3306/PCSDB";
		String username = "root";
		String password = "Praveenasingam@96";
		//LOADING DRIVER
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url, username, password);
		return conn;
	}
}
