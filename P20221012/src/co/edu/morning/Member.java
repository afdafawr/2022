package co.edu.morning;

public class Member {
	private String user;
	private String id;
	private int point;
	public Member(String user, String id, int point) {
		this.user = user;
		this.id = id;
		this.point = point;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "user=" + user + ", id=" + id + ", point=" + point;
	}
	
}
