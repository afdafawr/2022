package co.edu.variable;

public class MethodExample {
	//가로, 세로 -> 
	public static int getArea(int a, int b) {
		return a*b;
	}
	public static int sumArr(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	// 두수의 나눈 결과를 반환하는 메소드
	public static double divide(double a, double b)
	{
		return a/b;
	}
	//두 수를 나누는 작업, 매개변수를 int type
	public static double divide(int a, int b) {
		//유형 byte(1), short(2), int(4), long(8)
		//1byte(-128~127 8bit,제일앞은 부호)
		//실수 float(4),double(8)
		//강제형변황=캐스팅
		if(b ==0) {
			return 0;
		}
		double result = (double)a/b; // 유형이 다르면 큰쪽으로 자동형변환해줌.
		return result;
	}
	public static void main(String[] args) {
		int result = getArea(24,15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23,45,12};
		result = sumArr(intAry);
		System.out.println("전체 배열요소의 합은 " + result);
		
		// 실수. float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1+d2;
		d3 = divide(d1,d2);
		System.out.println(d3);
		System.out.println(divide(23,2));
		d3 = divide(3,2);
		System.out.println(d3);
		
	}
	
}