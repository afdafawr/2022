package co.edu.morning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Morning1014 {
	
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		while(true) {
		System.out.println("1.등록 2.조회 3.종료");
		int menu = Integer.parseInt(scn.nextLine());
		
		if(menu == 1) {
			write();
		}
		else if(menu ==2) {
			read();
		}
		else if(menu ==3) {
			System.out.println("종료합니다");
			break;
		}else {
			System.out.println("종료");
		}
		}
	}
	
	public static void write() {
		Scanner scn = new Scanner(System.in);
		List<Member> memlist = new ArrayList<Member>();
		//문자기반 스트림 생성. Reader/ Writer.
		try {
			FileWriter fw = new FileWriter("C:/Temp/memberList.txt");
			System.out.println("아이디 입력");
			String id = scn.nextLine();
			System.out.println("이름 입력");
			String name = scn.nextLine();
			System.out.println("포인트 입력");
			int point = Integer.parseInt(scn.nextLine());
			memlist.add(new Member(name, id, point));
			fw.write(memlist.toString());
			fw.close();
			scn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
	
	public static void read() {
		try {
			FileReader reader = new FileReader("C:/Temp/memberList.txt");
			while(true) {
				int bytes = reader.read(); // 2바이트씩 읽음 문자기반이라
				if(bytes == -1) {
					break;
				}
				System.out.print((char) bytes);				
			}
			reader.close();
			System.out.println("completed.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
