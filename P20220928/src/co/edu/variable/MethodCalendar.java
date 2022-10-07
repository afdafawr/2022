package co.edu.variable;

public class MethodCalendar {

	public static void main(String[] args) {
		mainCal(9);
	}
	public static void mainCal(int month) {
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		//요일 출력.
		for(String day : days){
			System.out.printf("%4s" , day);
		}
		System.out.println("\n");
		//1일의 위치 지정.
		for(int i = 0; i < getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		//날짜 출력
		for(int i = 1; i <= getLastDate(month); i++) {
			System.out.printf("%4s", i);
			if((i + getFirstDay(month))%7==0) {
				System.out.println("\n");
			}
		}
	} // end of makeCal()
	public static int getFirstDay(int month){
		if(month ==9) {
			return 4;
		}else if(month == 8) {
			return 1;
		}
		else if(month == 6) {
			return 3;
		}
		else if(month == 7) {
			return 5;
		}
		else
			return 4;
	}
	public static int getLastDate(int month) {
		//switch .. case ..
		switch(month) {
		case 9: 
			return 30;
		case 8:
			return 31;
		case 7:
			return 31;
		case 6:
			return 30;
		default: 
			return 30;
		}
	}
} //end of class