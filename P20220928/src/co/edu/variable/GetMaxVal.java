package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5];
		randomAry[0] = (int)(Math.random()*100)+1; // 0~1사이 임의수 생성.
		randomAry[1] = (int)(Math.random()*100)+1; // 0~1사이 임의수 생성.
		randomAry[2] = (int)(Math.random()*100)+1; // 0~1사이 임의수 생성.
		randomAry[3] = (int)(Math.random()*100)+1; // 0~1사이 임의수 생성.
		randomAry[4] = (int)(Math.random()*100)+1; // 0~1사이 임의수 생성.
		
		int maxVal = 0;
		int minVal = 0;
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
			if(randomAry[i]>maxVal)
				maxVal = randomAry[i];
			}
		
		minVal = maxVal;
		for(int i=0; i<5; i++) {
			if(randomAry[i]<minVal) {
				minVal = randomAry[i];
			}
			
		}

		System.out.println("최대값" + maxVal);

		System.out.println("최소값" + minVal);
	}
}