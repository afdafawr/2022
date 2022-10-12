package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	
	public static void main(String[] args) {
		search();
	}
	
	public static void update() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); //url 사용자계정 pw순
		
		stmt = conn.createStatement();
		int r = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id= 500"); //insert,delete,update
		System.out.println(r +"건 업데이트 되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//예외가 발생, 정상 처리가 되더라도 반드시 실행되야하는곳
			try {
//				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	public static void delete() {
		//jdbc driver 로드
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); //url 사용자계정 pw순
				
				stmt = conn.createStatement();
				int r = stmt.executeUpdate("delete from empl where employee_id=500"); //insert,delete,update
				System.out.println(r +"건 삭제 되었습니다");
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					//예외가 발생, 정상 처리가 되더라도 반드시 실행되야하는곳
					try {
//						rs.close();
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
	}
	public static void search() {
		//jdbc driver 로드
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from empl order by employee_id"); // select 경우 exequery
					// Set 컬렉션
					while(rs.next()) {
						System.out.println("사원번호" +rs.getInt("employee_id"));
						System.out.println("이름 :" +rs.getString("first_name"));
						System.out.println("급여 :" +rs.getString("salary"));
						System.out.println("======================================");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					//예외가 발생, 정상 처리가 되더라도 반드시 실행되야하는곳
					try {
						rs.close();
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				System.out.println("프로그램 종료");
	}
}
