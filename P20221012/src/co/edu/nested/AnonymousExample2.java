package co.edu.nested;

interface Run {
	void run();
}

class Runner implements Run{
	@Override
	public void run() {
		System.out.println("run");
	}
}
public class AnonymousExample2 {
	public static void main(String[] args) {
		
		//익명구현객체 :상황에따라 기능이 다를 경우에 씀.
		Run runner = new Run() { // 익명구현객체
			String kind;
			void runKind() {
				System.out.println("육상");
			}
			
			@Override
			public void run() {
				System.out.println("구현 run");
				runKind();
			}
			
			
		};
		runner.run();
		Run runner2 = new Run() {

			@Override
			public void run() {
				System.out.println("구기종목");
			}
		};
		runner2.run();
	}	
}
