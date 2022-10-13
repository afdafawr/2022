package co.edu.board;

public class User {
	private String id;
	private String passwd;
	private String user_name;
	
	public User(String id, String passwd, String user_name) {
		this.id = id;
		this.passwd = passwd;
		this.user_name = user_name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
