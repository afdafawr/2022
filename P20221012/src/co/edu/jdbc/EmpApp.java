package co.edu.jdbc;

import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		//์๋ ฅ
		
		int empId = 550;
		String lastName = "Hong";
		String email = "hongkil@email";
		String jobId = "ST_MAN";
		String hireDate = "2021-05-11";
		
		Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
//		empDao.insert(emp1);
//		empDao.update(emp1);
//		empDao.delete(550);
		System.out.println(empDao.getEmp(500));
		//์กฐํ
//		List<Employee> employees = empDao.search();
//		for(Employee emp : employees) {
//			System.out.println(emp);
//		}
		
	}
}
