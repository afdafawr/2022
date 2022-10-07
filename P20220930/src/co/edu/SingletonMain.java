package co.edu;

public class SingletonMain {
	public static void main(String[] args) {
		// 1) student 인스턴스에할당됨
		Student s1= new Student();
		Student s2= new Student();
		
		// 2) Singleton 클래스에 할당됨 s1를 sg2로그대로갖고옴
		Singleton sg1 = Singleton.getInStance();
		Singleton sg2 = Singleton.getInStance();
		
		System.out.println(s1==s2);
		System.out.println(sg1==sg2);
	}
}
