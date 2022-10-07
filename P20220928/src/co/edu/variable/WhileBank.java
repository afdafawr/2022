package co.edu.variable;

import java.util.Scanner;

public class WhileBank {
	public static void main(String[] args) {
		bankApp();
	}
	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		// 메뉴: 1.예금, 2.출금, 3:잔고, 4:종료
		int money = 0;
		// 10만원이 넘으면 저축불가
		while(run) {
			System.out.println("메뉴: 1.예금, 2.출금, 3:잔고, 4:종료");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				System.out.println("예금처리하는 메뉴");
				System.out.println("예금액을 입력 >>> ");
				int input = scn.nextInt();
				money = money + input;
				if(money>=100000)
				{
					money = money - input;
					System.out.println("초과");
					break;
				}
				
				break;
			case 2:
				System.out.println("출금처리하는 메뉴");
				System.out.println("출금액을 입력 >>> ");
				int input2 = scn.nextInt();
				
				if(money>input2) {
					money = money - input2;
					System.out.println("출금액은 :" + money);
				}
				else
					System.out.println("잔액 초과");
				break;
				
			case 3:
				System.out.println("잔고처리하는 메뉴");
				System.out.println("현재 잔고는 : " + money+"원입니다");
				break;
			case 4:
				System.out.println("종료하는 메뉴");
				run = false;
			}			
			
		} // end of bacnkapp
		System.out.println("end of prg");
	}
}
