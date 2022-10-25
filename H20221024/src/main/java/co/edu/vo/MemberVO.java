package co.edu.vo;

public class MemberVO {
	private String id;
	private String passwd;
	private String email;
	private String name;
	private String resposibility;
	
	public MemberVO(String id, String passwd, String email, String name, String resposibility) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
		this.resposibility = resposibility;
	}
	public MemberVO() {};
	public MemberVO(String id,String passwd, String name, String email) {
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResposibility() {
		return resposibility;
	}
	public void setResposibility(String resposibility) {
		this.resposibility = resposibility;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", email=" + email + ", name=" + name + ", resposibility="
				+ resposibility + "]";
	}
}