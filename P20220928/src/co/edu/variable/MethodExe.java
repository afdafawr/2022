package co.edu.variable;

public class MethodExe {
	
	//첫번째로 실행되는 ㅁㅔ소드
	public static void main(String[] args) {
		printStar(5);
		print("@");
		printCircle("◆",3);
		int result = sum(sum(2,3),sum(3,4));
		System.out.println("최종값은" + result);
	}
	public static void printStar() { //반환값, 매개변수 없는 메소드
		System.out.println("★");
	}
	public static void printStar(int times) {
		for(int i=0; i<times ; i++) {
			System.out.println("★");
		}
	}
	public static void print(String circle){
		System.out.println(circle);
	}
	public static void printCircle(String circle, int items) {
		for(int i= 0; i<items ; i++) {
			System.out.println(circle);
		}
	}
	public static int sum(int n1, int n2) {
		int result = n1 *2 + n2*3;
		System.out.println("결과값은" + result);
		return result; // int(반환값)이 있으니 return값 필요.
	}
}