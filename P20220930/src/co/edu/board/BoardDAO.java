package co.edu.board;

import java.util.Arrays;
import java.util.Scanner;

// 기능만.
public class BoardDAO {
	// Singleton 방식의 인스턴스 생성. 목적은 여러개의 인스턴스 안만드려고
	private static BoardDAO instance = new BoardDAO(); //static이면 클래스에 소속
	private BoardDAO() {} // 생성자
	public static BoardDAO getInstance() { //메소드
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];
	//1.글등록
	public void addBoard() {
		System.out.println("글등록 기능입니다");
		System.out.println("글번호 입력 >> ");
		int bNo = scn.nextInt();scn.nextLine();
		System.out.printf("글제목 입력 >> ");
		String title = scn.nextLine();
		System.out.printf("글내용 입력 >> ");
		String contents = scn.nextLine();
		
		Board brd = new Board(bNo, title, contents);
		//배열 등록.
		for(int i=0; i<myBoards.length; i++) {
		if(myBoards[i]==null) {
			myBoards[i] = brd;
			break;
			}
		}
	}	
	//2.글목록
	public void boardList() {
		System.out.println("글목록 기능입니다");
		for(Board brd : myBoards) {
			if(brd != null)
			{
				System.out.println(brd.toString());
			}
		}
	}
	//3.글상세보기
	public void boardDetail() {
		System.out.println("글상세보기 목록입니다");
		for(int i=0; i<myBoards.length; i++) {
		if(myBoards[i] != null)
		System.out.println(myBoards[i].toString());
		}
		System.out.println("글 번호를 입력하시오");
		System.out.println("글번호 입력 >> ");
		int bNo = scn.nextInt();
		
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && 
					bNo==myBoards[i].getBoardNo())				
				System.out.println(myBoards[i].toString());
			}
		}
		
		
	
	//4.글삭제
	public void delBoard() {
		System.out.println("글삭제 기능");
		System.out.println("글 번호를 입력하시오");
		int bNo = scn.nextInt();

		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && 
					bNo==myBoards[i].getBoardNo()) {
				myBoards[i]=null;
			}
		}
	}
	//5.전체메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.글등록 2.글목록 3.글상세보기 4.글삭제 5.종료");
			System.out.println("선택 >> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: addBoard(); 
					break;
			case 2: boardList();
					break;				
			case 3: boardDetail();
					break;
			case 4: delBoard();
					break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다");
			}
		}//end of while();
		System.out.println("프로그램 종료.");
	}// end of exe()
}
