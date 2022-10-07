package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;


public class MorningCode {
	public static void main(String[] args) {
		String tok = "Hello World Good Friend";
		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);
		ArrayList<Employees> list = new ArrayList<>();

	 //가지고올값이 있을때까지
//	 while(scn.hasNext())
//	 System.out.println(scn.next());
		String[] toks = tok.split(" ");
		ArrayList<String> emp2 = new ArrayList<String>();
		ArrayList<Employees> emp = new ArrayList<Employees>();
//		emp.add(new Employees("100","홍길동","2500"));
		for(String str : toks) {
		System.out.println(str);
		}
		while(true) {
		System.out.println("입력 >> ex) 100 홍길동 2500");
		String inputVal = scanner.nextLine();
		String[] vals = inputVal.split(" ");
		
		
		
		if(vals[0].equals("quit")) {
			break;
		}
		
		if(vals.length != 3) {
			System.out.println("다시입력하세요");
			continue;
		}
		list.add(new Employees(Integer.parseInt(vals[0]),vals[1],Integer.parseInt(vals[2]))); 
		}
		for(Employees emp22: list) {
			System.out.println(emp22.toString());
		}
		}
}

		//첫번째 값 => empId, 두번째 값 = empName, 세번째 값 => salary
		//Employee 클래스의 인스턴스 생성.
		//ArrayList에 저장.
		//종료를 하고 싶으면 quit 치고 종료.
		
		//for로 출력.

