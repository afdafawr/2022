package co.edu.board;

public class Reply {
	private int rep_seq;
	private int board_num;
	private String rep_content;
	private String rep_writer;
	private String creation_date;
	
	public Reply() {};
	
	
	@Override
	public String toString() {
		return "댓글번호 : " + rep_seq + ", 글번호 : " + board_num + ", 글 내용 : " + rep_content
				+ ", 글쓴이 " + rep_writer + ", 작성 날짜" + creation_date;
	}


	public Reply(int rep_seq, int board_num, String rep_content, String rep_writer) {
		
		this.rep_seq = rep_seq;
		this.board_num = board_num;
		this.rep_content = rep_content;
		this.rep_writer = rep_writer;
	}

	public Reply(int rep_seq, int board_num, String rep_content, String rep_writer, String creation_date) {
		this.rep_seq = rep_seq;
		this.board_num = board_num;
		this.rep_content = rep_content;
		this.rep_writer = rep_writer;
		this.creation_date = creation_date;
	}
	public int getRep_seq() {
		return rep_seq;
	}
	public void setRep_seq(int rep_seq) {
		this.rep_seq = rep_seq;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public String getRep_writer() {
		return rep_writer;
	}
	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
}
