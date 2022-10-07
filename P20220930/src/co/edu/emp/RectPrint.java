package co.edu.emp;

public class RectPrint {
	public static void main(String[] args) {
//		int cnt = 1;
//		for(int i =0; i<5; i++) {
//				cnt = i+1;
//			for(int j=0; j<5; j++) {
//				System.out.printf("%3d", cnt);
//				cnt = cnt+5;
//			}
//			System.out.println();
//		}
//		====2
		int cnt =5;
		for(int i =0; i<5; i++) {
			cnt--;
			for(int j=1; j<6; j++) {
				System.out.printf("%3d", (j*5)-cnt);
			}
			System.out.println();
		}
	}
}