package co.edu.variable;

import java.util.Scanner;

public class WhileBankApp {

	public static void main(String[] args) {
		// 메뉴 : 1.예금, 2.출금, 3.잔액, 4.종료
		Account[] banks = new Account[10];
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("0. 계좌생성, 1.예금, 2.출금, 3.잔액, 4.종료");
			int menu = scn.nextInt(); scn.nextLine();
			if(menu == 1) {
//예금기능. 계좌번호, 얼마 예금
				System.out.println("계좌번호 >>> ");
				String accNo = scn.nextLine();
				System.out.println("예금할 금액 >>> ");
				int money = scn.nextInt();
				for(int i=0; i<banks.length; i++)
				{
					if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
						banks[i].setBalance(money);
					}
				}
			}
			else if(menu == 2) {
				System.out.println("계좌번호 >>> ");
				String accNo = scn.nextLine();
				System.out.println("출금할 금액 >>> ");
				int money = scn.nextInt();
			for(int i=0; i<banks.length; i++)
			if(banks[i] != null && banks[i].getAccNo().equals(accNo)){
					{
						if(banks[i].getBalance()>= money )
							banks[i].setBalance(-money);
						else
							System.out.println("잔액 부족");
					}
				}
			}
			
			else if(menu == 3) {
				System.out.println("조회할 계좌번호 입력 >>>" );
				String accNo = scn.nextLine();
				for(int i=0; i<banks.length; i++)
				if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
					System.out.println("잔액: " + banks[i].getBalance());
				}
			}
			else if(menu == 4) {
				System.out.println("종료");
				break;
			}
			else if(menu == 0) {
					//계좌번호 생성
				System.out.println("계좌번호 생성 >>> ");
				String accNo = scn.nextLine();
				System.out.println("예금주 입력 >>> ");
				String owner = scn.nextLine();
				
				Account acc = new Account(); //  인스턴스 생성
				acc.setAccNo(accNo);
				acc.setOwner(owner);;
				for(int i=0; i<banks.length; i++) {
				if(banks[i] == null) {
					banks[i] = acc;
					break;
				}
				}
				System.out.println("계좌생성완료.");
			}
		}
	}
}