package co.edu.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//문자기반 스트림 생성. Reader/ Writer.
		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt");
			while(true) {
				System.out.print(">> ");
				String temp = scn.nextLine();
				
				if(temp.equals("quit"))
					break;
				fw.write(temp + "\n");
			}
			fw.close();
			scn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
}
