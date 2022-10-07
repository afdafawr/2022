package co.edu.variable;

public class SortExe {

	public static void main(String[] args) {
		int[] numAry = {34, 1,51,21,12};
		for(int i=0; i<numAry.length-1; i++)
		for(int j = 0; j<numAry.length-1; j++){
			if(numAry[j]>numAry[(j+1)])
			{
				int temp = numAry[j];
				numAry[j] = numAry[(j+1)];
				numAry[(j+1)] = temp;
			}
		}
		for(int n: numAry)
		System.out.print(n + " ");
	}
}
