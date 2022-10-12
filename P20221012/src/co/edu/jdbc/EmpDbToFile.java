package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile {
	public static void main(String[] args) {
		try {
		FileWriter fw = new FileWriter("c:/Temp/empFile.txt");
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


