package co.edu.board;

import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		boolean chk = true;
		System.out.println("로그인");
		String user = scn.nextLine();
		System.out.println("비밀번호 입력");
		String pw = scn.nextLine();
		chk = dao.check(user, pw);
		while(true) {
			
			
			if(chk == false) {
				break;
			}
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 6.댓글달기 9.종료");
		
			int menu = Integer.parseInt(scn.nextLine());
			if(menu==1) {
				System.out.println("글번호를 입력하시오 >>");
				
				int borid = Integer.parseInt(scn.nextLine());			
				System.out.println("글제목을 입력하시오 >>");
				String name = scn.nextLine();
				System.out.println("글내용을 입력하시오 >>");
				String content = scn.nextLine();
				dao.create(new Board(borid,name,content),user);
				
			}else if(menu==2) {
				System.out.println("변경할 글번호를 입력하시오 >>");
				int borid = Integer.parseInt(scn.nextLine());
				System.out.println("변경할 내용을 입력하시오 >>");
				String content = scn.nextLine();
				dao.update(new Board(borid, content),user);
			}else if(menu==3) {
				System.out.println("삭제할 글을 입력하시오 >>");
				int borid = Integer.parseInt(scn.nextLine());
				dao.delete(borid,user);
			}else if(menu==4) {
				List<Board> boa = dao.read();
				System.out.println("몇줄씩 볼껀가요?");
				int b = Integer.parseInt(scn.nextLine()); // 줄바꿈할 갯수
				int a = boa.size();
				System.out.println(a);
				try {
				for(int i = 0; i<(a/b)+1; i++)
				{
					for(int j=0; j<b; j++) {
						System.out.println(boa.get(j+b*i));		
					}
					System.out.println("다음 페이지 출력하려면 엔터를 치시오");
					scn.nextLine();
				}
				
				}catch(Exception e) {	
					System.out.println("마지막페이지 입니다");
				}
			}else if(menu==5) {
				String tmp = null;
				
				System.out.println("글번호를 입력해 주세요 >> ");
				int borid = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getbor(borid));
				
				System.out.println("댓글을 조회하시겠습니까?  :: Y/N");
				String yn = scn.nextLine();
				if(yn.equals("Y")) {
					List<Reply> rps = dao.rpshow(borid);
					for(Reply rp : rps) {
						System.out.println(rp.toString());
					}
				}
				else if(yn.equals("N")) {
				
				}
				else {
					System.out.println("잘못된 입력입니다");
				}
			}
			else if(menu==6) {
				System.out.println("글번호를 입력해 주세요 >> ");
				int borid = Integer.parseInt(scn.nextLine());
				System.out.println("댓글을 입력하시오 >>");
				String content = scn.nextLine();
				dao.reply(borid,user,content);
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

