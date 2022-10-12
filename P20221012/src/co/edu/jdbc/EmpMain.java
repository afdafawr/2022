package co.edu.jdbc;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args){
		// 1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄추가 9.종료
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu==1) {
				System.err.println("사원등록 메뉴입니다");
				System.out.println("==============");
				System.out.println("사원번호를 입력하시오 >>");
				try {
				int empid = Integer.parseInt(scn.nextLine());			
				System.out.println("이름을 입력하시오 >>");
				String name = scn.nextLine();
				System.out.println("이메일을 입력하시오 >>");
				String email = scn.nextLine();
				System.out.println("입사일을 입력하시오 >>");
				String hdate = scn.nextLine();
				System.out.println("부서이름을 입력하시오 >>");
				String jobid = scn.nextLine();
				dao.insert(new Employee(empid, name, email, hdate, jobid));
				}catch(Exception e) {
					System.out.println("양식에 맞게 입력하세요!!!");
				}
			}else if(menu==2) {
				System.err.println("한건조회 메뉴입니다");
				System.out.println("==============");
				System.out.println("사원번호를 입력해 주세요 >> ");
				int empid = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getEmp(empid));
			}else if(menu==3) {
				System.err.println("수정 메뉴입니다");
				System.out.println("==============");
				System.out.println("변경할 사원번호를 입력하시오 >>");
				int empid = Integer.parseInt(scn.nextLine());
				System.out.println("변경할 이메일을 입력하시오 >>");
				String email = scn.nextLine();
				System.out.println("변경할 입사일 입력하시오 >>");
				String hdate = scn.nextLine();
				System.out.println("변경할 부서이름을 입력하시오 >>");
				String jobid = scn.nextLine();
				Employee emp = new Employee(empid, jobid, email, hdate, jobid);
				dao.update(emp);
			}else if(menu==4) {
				System.out.println("삭제할 사원번호를 입력하시오 >>");
				int empid = Integer.parseInt(scn.nextLine());
				dao.delete(empid);
			}else if(menu==5) {
				List<Employee> employees = dao.search();
				for(Employee emp : employees) {
					System.out.println(emp);
				}
			}else if(menu==6) {
				dao.DbToFile();
			}
			
			else if(menu==9) {
				System.out.println("종료합니다");
				break;
			}else {
				System.out.println("잘못된 번호입니다");
			}
		}
		scn.close();
	}
}
