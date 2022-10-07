package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬랙션(ArrayList)으로 저장
public class EmployeeArrayList implements EmployeeService{
	ArrayList<Employee> list;
	Scanner scn = new Scanner(System.in);

	int idx;
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료");
	}

	@Override
	public void input() {
		System.out.println("사번 입력 >>");
		int eId = readInt("사번>>");
		System.out.println("사원이름 입력 >>");
		String empname = scn.nextLine();
		int empsal = readInt("급여 입력");
		int deptNo = readInt("부서 >> ");
		list.add(new Employee(eId, empname, empsal,deptNo));
		
	}
		
	
	
	@Override
	public String search(int employeeId) {
		String result = null;
//		for(int i=0; i<list.size(); i++) {
//			Employee emp = list.get(i);
//			if(emp.getEmployeeId()==employeeId)
//				result = emp.getName();
//			break;
//		}
		for(Employee emp : list) {
			if(emp.getEmployeeId()==employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n", 
				"사원번호", "이름", "급여");
		System.out.println("=============================");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", 
					list.get(i).getEmployeeId(), 
					list.get(i).getName(), 
					list.get(i).getSalary());
		}
	}

	@Override
	public int searchSal(int employeeID) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEmployeeId()==employeeID)
				result = list.get(i).getSalary();
				break;
			}
		return result;
	}
	public int readInt(String msg) {
		int result = -1;
		while(true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
				
			}catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			}
		}
		return result;
	}
	
	
}