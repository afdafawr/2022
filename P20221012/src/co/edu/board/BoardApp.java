package co.edu.board;

import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu==1) {
				System.out.println("글번호를 입력하시오 >>");
				try {
				int borid = Integer.parseInt(scn.nextLine());			
				System.out.println("글제목을 입력하시오 >>");
				String name = scn.nextLine();
				System.out.println("글내용을 입력하시오 >>");
				String content = scn.nextLine();
				System.out.println("글작성자를 입력하시오 >>");
				String writer = scn.nextLine();
				dao.create(new Board(borid,name,content,writer));
				}catch(Exception e) {
					System.out.println("양식에 맞게 입력하세요!!!");
				}
			}else if(menu==2) {
				System.out.println("변경할 글번호를 입력하시오 >>");
				int borid = Integer.parseInt(scn.nextLine());
				System.out.println("변경할 내용을 입력하시오 >>");
				String content = scn.nextLine();
				dao.update(new Board(borid, content));
			}else if(menu==3) {
				System.out.println("삭제할 글을 입력하시오 >>");
				int borid = Integer.parseInt(scn.nextLine());
				dao.delete(borid);
			}else if(menu==4) {
				List<Board> boa = dao.read();
				for(Board bor : boa) {
					System.out.println(bor);
				}
			}else if(menu==5) {
				System.out.println("글번호를 입력해 주세요 >> ");
				int borid = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getbor(borid));				
				}
						
			else if(menu==9) {
				System.out.println("종료합니다");
				break;
			}else {
				System.out.println("잘못된 번호입니다");
			}
		}
		scn.close();
	}
}
