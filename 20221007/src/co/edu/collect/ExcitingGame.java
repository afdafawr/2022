package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {

		long gamestart = System.currentTimeMillis();

		Scanner scn = new Scanner(System.in);
		String target = "Defines th";
		System.out.println(target);
		String[] targetAry = target.split(" ");

		boolean done = false;
		while (true) {
			done = true;
			
			System.out.println("지우고자 하는 문장을 입력하시오");
			String del = scn.nextLine();
			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(del)) {
					targetAry[i] = null;

				}
			}

			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					done = false;
				}
			}

			if (done)
				break;
			
		}
		long gameEnd = System.currentTimeMillis();
		System.out.println("걸린시간 " + (gameEnd - gamestart)/1000 + "초가 걸렸습니다");
	}

}
