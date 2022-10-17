package boradPG;

public class Board {
	
	private int no;
	private String title;
	private String content;
	private String writer; // 글쓴이 user로 할거
	private String date; // 날짜
	private int cnt; // 조회수
	
	public Board() {};
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public Board(int no, String title, String content, String writer, String date, int cnt) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.cnt = cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "글번호 " + no + " 글제목 " + title + " 글내용 " + content + " 글쓴이 " + writer + " 글쓴날짜 " + date
				+ " 조회수 " + cnt;
	}
	
	
}
