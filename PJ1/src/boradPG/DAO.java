package boradPG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	// Connection 객체를 반환해주는 getConnect
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	PreparedStatement psmt;
	
	public Connection getConnect() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); //url 사용자계정 pw순
		System.out.println("연결 성공");
	}catch(Exception e) {
		System.out.println("연결 실패");
	}
	return conn; // Connection 객체로 반환해야함
	}
	
	// Resource 해제하는 disconnect 
	public void disconnect() {
		try {
		
		if(rs != null)rs.close(); // rs값이 널이 아니면
		if(stmt != null)stmt.close();
		if(conn != null)conn.close();
		if(psmt != null)psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}