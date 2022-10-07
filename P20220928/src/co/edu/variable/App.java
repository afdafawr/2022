package co.edu.variable;

//자바는 class 시작.
//클래스의 main메소드로 시작.

public class App {
	public static void main(String[] args) {
		System.out.println("안녕하세요!!"); // (매개값을 출력)	
		
		//변수의 타입 지정. => 정수(int, long), 실수(double, float)
		//참/거짓(boolean) 문자열 : String
		
		int myAge = 25; // 왼쪽 = 오른값 타입이 항상 동일해야함.
//		myAge = "스물다섯" //컴파일 에러;sf
		String 내나이 = "스물다섯";
		내나이 = "28"; // 문자열 28.
		
		int result = myAge + 55;
		
		System.out.println(result);
		//배열
		//let numAry =[];
		int[] numAry = {20,29,13,44,88,33};
		int sum = 0;
		//1) 배열의 합계
		for(int i=0; i<numAry.length; i++) {
			
//		System.out.println(numAry[i]);
			if(i%2==0)
			sum += numAry[i];
		}
		System.out.println("짝수의 합은" +sum);
		//2 배열의 조건
		sum = 0; // 0값으로 초기화;
		for(int i=0; i<numAry.length; i++) {
			sum += numAry[i];
			System.out.println(sum);
			if(sum>=100) {
				System.out.println("100이 넘었습니다");
				break;
			}
			
		}
		System.out.println("정상커밋완료");
	}
}
