package boradPG;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		String id = null;
		boolean check = true;
		System.out.println("1.로그인 2.회원가입");
		int first = scn.nextInt();
		if(first==1) {
		System.out.println("로그인");
		scn.nextLine();
		System.out.println("아이디");
		id = scn.nextLine();
		System.out.println("비밀번호");
		String pw = scn.nextLine();
		check = dao.check(id, pw);
		}
		else if (first==2) {
		System.out.println("회원가입 기능입니다");
		scn.nextLine();
		System.out.println("아이디를 입력하시오");
		id = scn.nextLine();
		System.out.println("비밀번호를 입력하시오");
		String pw = scn.nextLine();
		System.out.println("닉네임을 입력하시오");
		String name = scn.nextLine();
		check = dao.sign(new User(id, pw, name));
		}
	
		while(true) {
		// 로그인,회원가입
		if(check==false) {
			break;
		}
		//로그인이 잘 됐나 안됐나 확인하는곳. 잘됐으면 밑에 이제 시작.
		System.out.println("1.공지사항 2.자유게시판 3.건의사항 4.회원관리 0.종료");
		int menu = scn.nextInt();
		int menu2;
		if(menu==1) {
			System.out.println("=====================");
			System.out.println("공지사항 게시판");
			System.out.println("=====================");
			dao.show(id,menu);
			System.out.println("1.글쓰기 2.글 상세보기 3.댓글보기 0.돌아가기");
			menu2 = scn.nextInt();
			if(menu2==1) {
				scn.nextLine();
				System.out.println("글 제목을 입력하세요");
				String title = scn.nextLine();
				System.out.println("글 내용을 입력하세요");
				String content = scn.nextLine();
				dao.write(new Board(title, content),id,menu);
			}else if(menu2==2) {	
				System.out.println("글 번호를 입력하세요");
				int no = scn.nextInt();
				System.out.println(dao.getbor(no, menu));
			}
		}else if(menu==2) {
			System.out.println("자유게시판 출력");
		}else if(menu==3) {
			System.out.println("건의사항 출력");
		}else if(menu==4) {
			System.out.println("회원관리");
		}else if(menu==0) {
			System.out.println("게시판을 종료합니다");
			break;
		}
		}
		
		}
	
}