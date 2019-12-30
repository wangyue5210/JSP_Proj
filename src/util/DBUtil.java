package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUtil {
	
	private DBUtil(){}
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	private static final String url="jdbc:mysql://localhost:3306/training?serverTimezone=UTC";
	private static final String user="root";
	private static final String password="root";
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void DBClose(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException {
		
		if (rs!=null) {
			rs.close();
			
		}
		if (ps!=null) {
			ps.close();
			
		}
		if (conn!=null) {
			conn.close();
			
		}
	} 
	
	

}
