package boradPG;

public class User {
	private String id; // 아이디
	private String pw; // 비밀번호
	private String user; // 닉네임
	
	
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public User(String id, String pw, String user) {
		super();
		this.id = id;
		this.pw = pw;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", pw=" + pw + ", user=" + user + "]";
	}
	
	
	
}
