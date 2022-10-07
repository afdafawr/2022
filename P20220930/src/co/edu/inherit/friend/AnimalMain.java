package co.edu.inherit.friend;

public class AnimalMain {
	public static void main(String[] args) {
//		Animal animal = new Animal(); 생성자로 인스턴스를 못만듬
		Animal cat = new Cat();
		Animal dog = new Dog();
		cat.eat();
		dog.eat();
	}
}
