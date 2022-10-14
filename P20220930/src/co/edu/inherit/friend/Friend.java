package co.edu.inherit.friend;

public class Friend {
	private String name;
	private String phone;
	
	public Friend() {} //기본생성자 생성, 상속받는 ComFriend클래스가 오류가 안나도록 하기위해.
	public Friend(String name, String phone) {
		super(); // object(부모클래스)의 생성자 호출 없어도 가능
		this.name = name;
		this.phone = phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		returnn this.phone;
	}
	public String showInfo() {
		return "친구의 이름은" + name + ", 연락처는 " + phone;
	}
}
