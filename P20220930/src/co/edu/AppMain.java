package co.edu;

// 하나의 실행클래스와 여러개의 라이브러리 클래스.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스 생성
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("사과");

		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("과일");
		
		Student stud1 = new Student();
		stud1.setStudNo("1234");
		stud1.setMajor("컴공");
		stud1.setStudName("김씨");
		
		Student stud2 = new Student();
		stud2.setStudNo("1235");
		stud2.setMajor("화공");
		stud2.setStudName("박씨");
		
		Student stud3 = new Student();
		
		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud : students) { // students 갯수만큼 stud에 값을 넣음
			System.out.println("학번 : " + stud.getStudNo() + ", 이름 " + stud.getStudName()
			+ ", 학과 : " + stud.getMajor());
		}
		// 상속.
		WorkMan wman = new WorkMan();
		wman.age = 1;
		wman.name = "직장인";
		
		StudMan sman = new StudMan();
		sman.school = "고딩";
		sman.height = 164.3;
	}
}
