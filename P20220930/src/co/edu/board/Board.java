package co.edu.board;

public class Board {
	private int boardNo; //글번호
	private String title; //글제목
	private String content; //글내용
	
	public Board() {} //매개변수가 없는 기본생성자.
	
	public Board(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title +
				", content=" + content + "] \n";
	}
	
}
