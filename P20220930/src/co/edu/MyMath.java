package co.edu;

public class MyMath {
	// 절대값을 구하는 메소드
	// 3의5승
	public static int abs(int num) {
		return num > 0 ? num : -num;
	}
	public static int power(int base, int exponent) {
		int result=1;
		for(int i=0; i<exponent; i++) {
			result *= base;
		}
		return result;
	}
}
