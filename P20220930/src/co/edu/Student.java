package co.edu;

import java.util.Arrays;

public class Student {
	//필드(속성들)
	private String studNo;
	private String studName;
	private String major;
	private int age;
	private String[] hobbies = new String[5];
	
	//정적 메소드.
	public static void staticMethod() { // 소속이 클래스
		System.out.println("staticMethod call.");
	}
	
	//생성자(필드의 값을 초기화) 생성자 오버로딩(동일한 이름의 생성자를 여러번 정의)
	public Student() {
		this.studNo = "기본값";
		this.studName = "기본값";
		this.major = "111-111";
		//매개값이 없는 생성자 => 기본생성자.
	}
	public Student(String studNo, String studName) {
		this.studNo = studNo;
		this.studName = studName;
	}
	
	public Student(String studNo, String studName, String major) {
		this(studNo, studName);
		this.major = major;
	}
	//메소드
	String[] getHobbies() {
		return this.hobbies;
	}
	void setHobbies(String[] hobbies) {
		//this.hobbies = hobbies;
		for(String hobby : hobbies) {
			for(int i=0; i<this.hobbies.length; i++) {
				if(this.hobbies[i]==null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby : hobbies) {
			if(hobby != null)
			str += hobby + " ";
		}
		str += "입니다";
		return str;
	}
	//취미 추가
	void addHobby(String hobby) {
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}
	
	
	
	void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	String getStudNo() {
		return this.studNo;
	}
	
	void setAge(int age) {
		if(age < 0) {
			this.age = 0;
		}
		else
		{
			this.age = age;
		}
	}
	int getAge() {
		return this.age;
	}
	
	//학생이름 set,get
	void setStudName(String studName) {
		this.studName = studName;
	}
	String getStudName() {
		return this.studName;
	}
	
	void setMajor(String major) {
		this.major = major;
	}
	String getMajor() {
		return this.major;
	}
	//showInfo()
	public String showInfo() {
		return "이름은 " + this.studName + "이고 학번은 " + this.studNo + "이고, 전공은 " +this.major + "입니다";
	}
	
	void study() {
		System.out.println(studName + "공부함");
	}
	void play() {
		System.out.println(studName + "게임함");
	}
	void sleep() {
		System.out.println(studName + "잠잔다");
	}

	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", studName=" + studName + ", major=" + major + ", age=" + age
				+ ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
}
