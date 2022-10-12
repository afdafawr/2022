package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO{
	
	public void delete(int empId) {
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from empl where employee_id="+empId); //insert,delete,update
			System.out.println(r +"건 삭제 되었습니다");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	//업데이트
	public void update(Employee emp) {
		String sql = "update empl " //
				+ "set email = ?, " //
				+ "hire_date = ?, " //
				+ "job_id = ? " //
				+ "where employee_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r= psmt.executeUpdate();
			System.out.println(r+"건이 수정되었습니다");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//등록
	public void insert(Employee emp) {
		System.out.println(emp);
		String sql = "insert into empl (employee_id, last_name, email, hire_date,job_id)\r\n"
				+ "values (" + emp.getEmployeeId() 
				+", '" + emp.getLastName()
				+"' , '" + emp.getEmail()
				+"' , '" + emp.getHireDate()
				+"' , '" + emp.getJobId()
				+"')";
		System.out.println(sql);
		conn= getConnect();
		try {
		stmt = conn.createStatement();
		int r = stmt.executeUpdate(sql);
		System.out.println(r + "건이 입력되었습니다");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//조회
	public List<Employee> search() {
		List<Employee> list = new ArrayList<>();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl order by 1");
			while(rs.next()) { //1번째 값을 불러와서
				list.add(new Employee(rs.getInt("employee_id")
						,rs.getString("last_name")
						,rs.getString("email")
						,rs.getString("hire_date")
						,rs.getString("job_id")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	public Employee getEmp(int empId) {
		conn = getConnect();
		Employee result = new Employee();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl where employee_id = "+empId); // 하나 불러오겟다
			while(rs.next()) { //1번째 값을 불러와서
			 result = new Employee(rs.getInt("employee_id")
						,rs.getString("last_name")
						,rs.getString("email")
						,rs.getString("hire_date")
						,rs.getString("job_id")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public void DbToFile() {
		try {
			FileWriter fw = new FileWriter("c:/Temp/emplist.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search();
			
			for(Employee emp : list) {
				int id = emp.getEmployeeId();
				String name = emp.getLastName();
				String email = emp.getEmail();
				String hiredate = emp.getHireDate();
				String jobid = emp.getJobId();
				fw.write(id +" ,"+ name+" ," + email+" ," + hiredate+" ,"+ jobid + "\n");	
			}
			fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
}
