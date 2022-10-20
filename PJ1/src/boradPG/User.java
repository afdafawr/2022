package boradPG;

public class User {
	private String id; // 아이디
	private String pw; // 비밀번호
	private String tel; // 전화번호
	private String mail;
	
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public User(String id, String pw, String tel,String mail) {
		super();
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.mail = mail;
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
		return tel;
	}
	public void setUser(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", pw=" + pw + ", tel=" + tel + "]";
	}
	
	
	
}
