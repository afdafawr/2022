package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조
		String str = "Hello World!!";
		//예외처리. RuntimeException 상속받아서 처리하는 예외클래스
		try {
			String result = str.substring(0,10);
			char chr = result.charAt(7);
			System.out.println(result);
			System.out.println(chr);
		}catch(NullPointerException e) {
			System.out.println("참조하는 값이 없습니다.");
		}
		
		Scanner scn = new Scanner(System.in);
		while(true) {
		System.out.println("숫자를 입력하세요 >>> ");
		try {
		int menu = scn.nextInt(); // InputMismatchException
		System.out.println("입력한값은 " + menu);
		break;
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요!");
			scn.nextLine(); // abc(Enter)
		}finally {
			System.out.println("반드시 실행할 코드.");
			//db connection 사용하고 resource 반환.
		}
		}
		try {
			exceptMethod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}//end main
	public static void exceptMethod() throws ClassNotFoundException {
		//일반예외 : Exception 상속받아서 처리하는 예외클래스.
//				try {
					Class.forName("java.lang.String");
//				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
	}
	
}
