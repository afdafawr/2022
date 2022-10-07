package co.edu.emp;

import java.util.Scanner;

// 메인클래스.
public class EmployeeApp {
	public static void main(String[] args) {
		// 1.사원수(초기화.배열크기지정) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
		Scanner scn = new Scanner(System.in);
		EmployeeService service = new EmployeeArrayList();
		
		
		while(true) {
			
			System.out.println("1.사원수(초기화.배열크기지정) 2.사원정보입력 3.사원검색 4.사원리스트 5.사원급여 검색 9.종료");
			System.out.println("선택하세요 >> ");
			
			int menu = Integer.parseInt(scn.nextLine()); // "1" -> 1
			if(menu == 1) {
				service.init();
			}else if(menu == 2) {
				service.input();
			}else if(menu == 3) {
				System.out.println("검색할 사원 번호 입력 >>");
				int eId = Integer.parseInt(scn.nextLine());
				String name = service.search(eId);
				if(name == null) {
					System.out.println("결과가 없습니다");
				}else {
				System.out.println("사원의 이름은 "+ name);}
				}else if(menu == 4) {
				service.print();
			}else if(menu == 5) {
				System.out.println("검색할 사원 번호 입력 >>");
				int eId = Integer.parseInt(scn.nextLine());
				String name = service.search(eId);
				int sal = service.searchSal(eId);
				if(name == null) {
					System.out.println("찾는 사원번호가 없습니다");
				}else {
				System.out.println("사원의 급여는  "+ sal);}
			}
				else if(menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			else
				System.out.println("잘못된 입력입니다");
				
			

	}System.out.println("프로그램 종료.");
	}//end of main()
}//end of class
