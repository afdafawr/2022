package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample3 {
	public static void main(String[] args) {
		//1.저장 2.조회 3.종료
		Map<String , Integer> students = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.저장 2.조회. 3.종료");
			System.out.println("선택 >> ");
			
			int menu = scn.nextInt();
			if(menu ==1) {
				scn.nextLine();
				System.out.print("학생이름입력 >> ");
				String name = scn.nextLine(); // key
				System.out.print("학생점수입력 >> ");
				try {
				int score = Integer.parseInt(scn.nextLine()); // value
				students.put(name, score);
				}catch(NumberFormatException e) {
					System.out.println("숫자로 입력하세요");
				}
			}else if(menu == 2) {
				scn.nextLine();
				System.out.print("조회할 학생이름입력 >> ");
				String searchName = scn.nextLine();
				System.out.println(students.get(searchName));
			}else if(menu == 3) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}//end of while
		System.out.println("프로그램 종료");
	} //end of prog
}
