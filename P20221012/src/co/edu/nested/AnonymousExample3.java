package co.edu.nested;

// 익명구현객체
// 추상메소드 하나만 존재하는 인터페이스 =>Functional 인터페이스. 
interface MyInterace{
	void run();
}
interface MyInterface2{
	void run(String kind);
}

interface MyInterface3{
	int sum(int num1, int num2);
}
public class AnonymousExample3 {
	public static void main(String[] args) {
		
		// ()이라는 매개값을 받아서 뒤에있는걸 구현하겟다
		// 람다표현식
		MyInterace intf = () -> System.out.println("MyInterface Run");
		MyInterface2 intf2 = kind -> System.out.println(kind + " Run.");
		MyInterface3 intf3 = (num1, num2) -> num1*2 + num2;
		int result = intf3.sum(10,20);
		System.out.println(result);
//		MyInterface2 intf2 = (String kind) -> System.out.println(kind + "Run");
		intf.run();
		intf2.run("농구종목");
		intf3 = (num1, num2) -> num1*2 + num2*3;
		result = intf3.sum(11, 12);
		System.out.println(result);
	}
}
