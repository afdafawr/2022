package co.edu.except;

class NegativeValueException extends RuntimeException{
	public NegativeValueException() {
		// TODO Auto-generated constructor stub
	}
	NegativeValueException(String msg){
		super(msg);
	}
}
public class ExceptionTest2 {
	public static void main(String[] args) {
	 try {
		positiveVal(10, -20);
	} catch (NegativeValueException e) {
		// TODO Auto-generated catch block
		System.out.println("에외가 발생");
	}
	 System.out.println("프로그램 종료.");
	}
	public static int positiveVal(int n1, int n2) throws NegativeValueException {
		int result = n1 + n2;
		if(result <0) {
			throw new NegativeValueException("음의값이 발생");
		}
		
		return result;
	}
}
