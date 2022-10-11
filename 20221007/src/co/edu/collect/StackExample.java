package co.edu.collect;

import java.util.Stack;

class Coin{
	private int val;
	public Coin(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
}

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>(); // 코인 인스턴스만 담겠다
		//추가.
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(80));
	
		//출력.
		while(!coinBox.isEmpty()) { //값이 있을때
			Coin coin = coinBox.pop(); // 마지막 인스턴스부터 꺼내기
			System.out.println(coin.getVal());
		}
	}
}
