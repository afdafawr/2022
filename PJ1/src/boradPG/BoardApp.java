package boradPG;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;


public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		String id = null;
		boolean check = true;
		int menu, menu2;
//관리자 id는 hr/hr.
		
		while(true) {
		// 로그인,회원가입
			
			if(check!=false) {
			System.out.println("==================");
			System.out.println("1.로그인 2.회원가입 3.비밀번호 찾기");
			System.out.println("==================");
			int first = scn.nextInt();
			if(first==1) {
			System.out.println("로그인");
			System.out.println("==================");
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
			System.out.println("번호를 입력하시오");
			String tel = scn.nextLine();
			System.out.println("메일을 입력하시오");
			String mail = scn.nextLine();
			check = dao.sign(new User(id, pw, tel,mail));
			}
			else if(first==3) {
				scn.nextLine();
				System.out.println("찾고자하는 아이디를 입력하세요");
				String sid = scn.nextLine();
				dao.searchpw(sid);
			}
			}
			
		
		//로그인이 잘 됐나 안됐나 확인하는곳. 잘됐으면 밑에 이제 시작.
		else {
		if(id.equals("hr")) {
			System.out.println("관리자 계정입니다");
			
		}
		System.out.println("==================================================================================================");
		System.out.println("1.공지사항 2.자유게시판 3.건의사항 4.관리자 메뉴 5.모든글보기 6.파일로 만들기 0.종료");
		System.out.println("==================================================================================================");
		menu = scn.nextInt();
	
		if(menu==1) {
			while(true) {
			System.out.println("==================================================================================================");
			System.out.println("공지사항 게시판");
			System.out.println("==================================================================================================");
			dao.show(id,menu);
			System.out.println("==================================================================================================");
			System.out.println("1.글쓰기 2.글 상세보기 3.글 삭제 4.글 수정 0.돌아가기");
			menu2 = scn.nextInt();
			if(menu2==1) {
				if(id.equals("hr")) {
				scn.nextLine();
				System.out.println("글 제목을 입력하세요");
				String title = scn.nextLine();
				System.out.println("글 내용을 입력하세요");
				String content = scn.nextLine();
				System.out.println("==================================================================================================");
				dao.write(new Board(title, content),id,menu);
				System.out.println("==================================================================================================");
				
				}
				else {
					System.out.println("관리자가 아닙니다");
				}
			}else if(menu2==2) {	
				System.out.println("글 번호를 입력하세요");
				int no = scn.nextInt();
				System.out.println(dao.getbor(no, menu));
				
				scn.nextLine();
				System.out.println("==================================================================================================");
				System.out.println("이 글을 좋아요 하시겠습니까 ? Y/N");
				String chkk = scn.nextLine();
				dao.mind(no,chkk,menu);
				System.out.println("==================================================================================================");
				System.out.println("댓글을 보고싶다면 Y 돌아가려면 N 입력.");
				String chk = scn.nextLine();
				if(chk.toUpperCase().equals("Y")) {
					for(Reply r: dao.rpshow(no))
					{
						System.out.println(r);
					}
				System.out.println("==================================================================================================");
					System.out.println("댓글을 쓰시겠습니까 Y/N");
					String chk2 = scn.nextLine();
					if(chk2.toUpperCase().equals("Y")) {
						System.out.println("내용을 입력하세요 >> " );
						String rp = scn.nextLine();
						dao.reply(no, id, rp,menu);
					}
				}
			}else if(menu2 == 3) {
				System.out.println("삭제할 글 번호를 입력하세요!!");
				int no = scn.nextInt();
				dao.delete(menu,no,id);
			}else if(menu2 ==4) {
				System.out.println("변경할 글번호를 입력하시오 >>");
				int borid = scn.nextInt();
				System.out.println("변경할 내용을 입력하시오 >>");
				scn.nextLine();
				String content = scn.nextLine();
				dao.update(new Board(borid, content),id,menu);
			}else if(menu2 == 0) {
				break;
			}
			}
		}else if(menu==2) {
			while(true) {
			System.out.println("==================================================================================================");
			System.out.println("자유 게시판");
			System.out.println("==================================================================================================");
			dao.show(id,menu);
			System.out.println("==================================================================================================");
			System.out.println("1.글쓰기 2.글 상세보기 3.글 삭제 4.글 수정 0.돌아가기");
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
				System.out.println("==================================================================================================");
				scn.nextLine();
				System.out.println("이 글을 좋아요 하시겠습니까 ? Y/N");
				String chkk = scn.nextLine();
				dao.mind(no,chkk,menu);
				System.out.println("==================================================================================================");
				
				
				System.out.println("댓글을 보고싶다면 Y 돌아가려면 N 입력.");
				String chk = scn.nextLine();
				if(chk.equals("Y")) {
					for(Reply r: dao.rpshow(no))
					{
						System.out.println(r);
					}
					System.out.println("댓글을 쓰시겠습니까 Y/N");
					String chk2 = scn.nextLine();
					if(chk2.toUpperCase().equals("Y")) {
						System.out.println("내용을 입력하세요 >> " );
						String rp = scn.nextLine();
						dao.reply(no, id, rp,menu);
					}
				}
			}else if(menu2 == 3) {
				System.out.println("삭제할 글 번호를 입력하세요!!");
				int no = scn.nextInt();
				dao.delete(menu,no,id);
			}else if(menu2 ==4) {
				System.out.println("변경할 글번호를 입력하시오 >>");
				int borid = scn.nextInt();
				System.out.println("변경할 내용을 입력하시오 >>");
				scn.nextLine();
				String content = scn.nextLine();
				dao.update(new Board(borid, content),id,menu);
			}else if(menu2 == 0) {
				break;
			}
			}
		}else if(menu==3) {
			while(true) {
			System.out.println("==================================================================================================");
			System.out.println("건의사항 게시판");
			System.out.println("==================================================================================================");
			dao.show(id,menu);
			System.out.println("==================================================================================================");
			System.out.println("1.글쓰기 2.글 상세보기 3. 글 삭제 4.글 수정 0.돌아가기");
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
				System.out.println("==================================================================================================");
//공감수 출력		
				scn.nextLine();
				System.out.println("이 글을 좋아요 하시겠습니까 ? Y/N");
				String chkk = scn.nextLine();
				dao.mind(no,chkk,menu);
				System.out.println("==================================================================================================");
				
				System.out.println("댓글을 보고싶다면 Y 돌아가려면 N 입력.");
				String chk = scn.nextLine();
				if(chk.equals("Y")) {
					for(Reply r: dao.rpshow(no))
					{
						System.out.println(r);
					}
					System.out.println("==================================================================================================");
					System.out.println("댓글을 쓰시겠습니까 Y/N");
					String chk2 = scn.nextLine();
					
					if(chk2.toUpperCase().equals("Y")) {
						System.out.println("내용을 입력하세요 >> " );
						String rp = scn.nextLine();
						dao.reply(no, id, rp,menu);
					}
				}
			}else if(menu2 == 3) {
				System.out.println("삭제할 글 번호를 입력하세요!!");
				int no = scn.nextInt();
				dao.delete(menu,no,id);
			}else if(menu2 ==4) {
				System.out.println("변경할 글번호를 입력하시오 >>");
				int borid = scn.nextInt();
				System.out.println("변경할 내용을 입력하시오 >>");
				scn.nextLine();
				String content = scn.nextLine();
				dao.update(new Board(borid, content),id,menu);
			}else if(menu2==0) {
				break;
			}
			}
		}else if(menu==4) {
			while(true) {
			System.out.println("==================================================================================================");
			System.out.println("관리자 메뉴");
			System.out.println("==================================================================================================");
			if(id.equals("hr")) {
				System.out.println("1.게시글 삭제, 2.게시글 수정 0.돌아가기");
				int me = scn.nextInt();
				if(me==1) {
					dao.allshow();
					System.out.println("삭제할 글 번호를 입력하세요");
					int del = scn.nextInt();
					dao.delete(menu, del, id);
				}else if(me==2) {
					System.out.println("블라인드 할 글의 번호를 입력하세요");
					int del = scn.nextInt();
					dao.blind(del);
				}else if(me==0) {
					break;
				}
				
			}else {
				System.out.println("관리자가 아닙니다");
				}
			}
		}else if(menu == 5) {
			
			List<Board> boa = dao.allshow();
			System.out.println("몇줄씩 볼껀가요?");
			int b = scn.nextInt(); // 줄바꿈할 갯수
			scn.nextLine();
			int a = boa.size();
			try {
			for(int i = 0; i<(a/b)+1; i++)
			{
				System.out.println("==================================================================================================");
				for(int j=0; j<b; j++) {
					System.out.println(boa.get(j+b*i));		
				}
				System.out.println("==================================================================================================");
				System.out.println("다음 페이지 출력하려면 엔터를 치시오");
				scn.nextLine();
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("마지막페이지 입니다");
				}
			}
		else if(menu==6) {
			dao.BoardDbToFile();
		}
		else if(menu==0) {
			System.out.println("게시판을 종료합니다");
			break;
		}
		}
		}
	}
}	