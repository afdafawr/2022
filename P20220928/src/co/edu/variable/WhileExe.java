package co.edu.variable;

import java.util.Scanner;

public class WhileExe {

	public static void main(String[] args) {
		whileFnc3();
	}
	public static void whileFnc2() {
		//while 구문.
		Scanner scn = new Scanner(System.in); //컨트롤 시프트 o
		while(true){
			System.out.println("값을 입력하세요. 종료하려면 stop 입력");
			String inputVal = scn.nextLine();
			if(inputVal.equals("stop")) {//문자열비교는 equals
			System.out.println("end Program");
				break;
			}
			System.out.println("사용자입력값 >" + inputVal);
			 // 시스템자원을 반환.
		}
		scn.close();
	}
	public static void whileFnc3() {
		//보고싶은 달을 입력. 종료하고싶으면 9를 입력
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("읽고싶은 달을 입력하시오, 종료하려면 -1");
			int input = scn.nextInt();
			if(input == -1) {
				System.out.println("end program");
				break;
			}
			else
			{
				MethodCalendar.mainCal(input);
				System.out.println("\n");
			}
			
		}
		scn.close();
	}
	public static void whileFnc() {
		//for 반복문: 반복회수. for(int i=0; i<10; i++){}
		int i = 0;
		while(i<4){
			System.out.println(i);
			i++;
		}
		System.out.println("end Program");
	}
}
