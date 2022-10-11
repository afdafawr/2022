package co.edu.memo;

import java.util.Scanner;

import co.edu.memo.except.ExitException;
import co.edu.memo.except.MenuException;

public class MemoApp {
	public static void main(String[] args) {
		MemoManager menager = MemoManager.getInstance();
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			try {
			System.out.println("1.등록 2.검색 3.삭제 4.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu < MENU.INSERT || menu > MENU.EXIT) {
				throw new MenuException(menu);
			}
			
			switch(menu) {
			case MENU.INSERT:
				menager.inputData();
				break;
			
			case MENU.SEARCH:
				menager.searchData();
				break;
			
			case MENU.DELETE:
				menager.deleteData();
				break;
			
			case MENU.EXIT:
				menager.storeToFile();
				throw new ExitException();
			}
			
			}catch (MenuException e) {
				e.showErrMessage();
			}catch (ExitException e) {
				break;
			}
		}
		System.out.println("프로그램 종료");
		scn.close();
	}
}
