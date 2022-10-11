package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
	public static void main(String[] args) throws Exception{
		Scanner scn = new Scanner(System.in);
		// C:/Temp/emp.dat 읽는 내용 구현
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		
		
		while(true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
			System.out.print("선택 >>>> ");
			int menu = scn.nextInt();
			String[] empAry = null;
			if(menu == 1) {
				System.out.println("등록메뉴입니다");
				System.out.println("===========");
				System.out.print(">> ");
				String empVal = scn.nextLine();
				empAry = empVal.split(" ");
				empList.add(new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]));
			
			}else if(menu == 2) {
				for(Emp emp:empList) {
					System.out.println(emp.toString());
				}
			}else if(menu == 3) {
				System.out.println("삭제할 사원 번호를 입력하시오");
				int id = scn.nextInt();
				for(int i=0; i<empList.size(); i++) {
					if(id == empList.get(i).id) {
						empList.remove(i);
					}
				}
			}
			else if(menu == 4) {
				FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(empList);
				break;
			}else {
				System.out.println("잘못된 메뉴입니다");
			}
			
		}
		System.out.println("종료되었습니다.");
	}
}
