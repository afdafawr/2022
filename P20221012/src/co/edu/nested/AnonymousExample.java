package co.edu.nested;

class People{
	int height;
	int weight;
	
	void showInfo() {
		System.out.println("showInfo");
	}
	
}
class Student extends People{
	int studNo;
}
public class AnonymousExample {
	//익명 상속 클래스.
	public static void main(String[] args) {
		People people = new People() {
			
			String color;
			
			@Override
			void showInfo() {
				System.out.println("익명 showInfo");
				showColor();
			}
			void showColor() {
				System.out.println(this.color);
			}
		};
		people.showInfo();
	}
	
}
