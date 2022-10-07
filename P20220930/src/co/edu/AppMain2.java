package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
		System.out.println(MyMath.abs(-100));
		Student.staticMethod(); // 인스턴스를 안만들어도 사용가능함
		
		Math.random();
		Math.round(1000.1);
		
		Student s1 = new Student();
//		s1.staticMethod(); //error는 아닌데 warning.
		
		s1.setStudNo("1-111");
		s1.setStudName("홍길동");
		s1.setMajor("컴퓨터공학과");
		s1.setAge(20);
		
		System.out.println(s1.getStudNo());
		System.out.println(s1.getAge());
		System.out.println(s1.showInfo());
		
		System.out.println("여기 =>>> " + s1);
		
		Student s2 = new Student();
		s2.setStudName("김민숙");
		s2.setStudNo("1-112");
		s2.setMajor("기공");
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());
		
		Student s3 = new Student();
		System.out.println(s3.getStudName());
		
		Student s4 = new Student("111-234", "김동욱","컴공");
		System.out.println(s4.showInfo());
	}
}
