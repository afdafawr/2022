package co.edu.board;

public class Board {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String date;
	private int count;
	
	public Board() {};
	
	public Board(int no, String title, String content, String writer, String date, int count) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.count = count;
	}
	public Board(int no, String title, String content, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}
	public Board(int no, String content) {
		this.no = no;
		this.content =content;
	}
	
	@Override
	public String toString() {
		return "글번호 : " + no + " 글제목 : " + title + " 작성자 : " + writer +  "글내용 : "+ content+ " 작성일시 : " +date + " 조회수 : " + count; 
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
