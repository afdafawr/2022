package co.edu.emp;

import java.util.Scanner;

// 배열을 활용해서 정보 저장.
public class EmployeeArray implements EmployeeService{
	Employee[] list;
	int idx;
	Scanner scn = new Scanner(System.in);
	@Override
	public void init() {
		System.out.println("사원수를 입력하시오");
		int cnt = Integer.parseInt(scn.nextLine()); //엔터키 처리 바로하려고
		list = new Employee[cnt]; //cnt개 인스턴스를 저장할 수 있는 공간 생성.
		System.out.println(cnt + "명의 사원 지정완료");
	}

	@Override
	public void input() {
		if(idx >= list.length) {
			System.out.println("더 이상 입력 불가");
			return; // 메소드 종료.
		}
		System.out.println("사원번호 입력 >>");
		int empno = Integer.parseInt(scn.nextLine());
		System.out.println("사원이름 입력 >>");
		String empname = scn.nextLine();
		System.out.println("사원급여 입력 >>");
		int empsalary = Integer.parseInt(scn.nextLine());
		System.out.println("부서번호 입력 >>");
		int deptno = Integer.parseInt(scn.nextLine());
		System.out.println("이메일 입력 >>");
		String email = scn.nextLine();
		Employee result = new Employee(empno, empname, empsalary,deptno,email);
		list[idx++] = result;		
//		for(int i=0;i<list.length; i++) {
//			if(list[i] == null) {
//				list[i] = result; 
//				break;
//			}
//		}
	}

	@Override
	public String search(int employeeId) {
		//입력된 값중에서 찾도록. list[5] => idx
		//100,200,300		
		String result = null;
		for(int i=0; i<idx; i++) {
			if(list[i].getEmployeeId() == employeeId) {
				result = list[i].getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) {
			System.out.printf("");
			System.out.printf("%5d %10s %7d\n", 
					list[i].getEmployeeId(), 
					list[i].getName(), 
					list[i].getSalary());
		}
	}

	@Override
	public int searchSal(int employeeID) {
		int result = 0;
		for(int i=0; i<idx; i++) {
			if(list[i].getEmployeeId() == employeeID) {
				result = list[i].getSalary();
				break;
			}
		}
		return result;
	}


}
