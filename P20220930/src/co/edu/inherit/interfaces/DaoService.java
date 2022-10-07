package co.edu.inherit.interfaces;

public interface DaoService {
	// 필드 없음, 생성자 X, 
	// 선언되는 모든 메소드는 추상메소드
	// 상수값을 정의. 변하지않는값
	
	public abstract void insert(); // 추상메소드. abstract 안붙여도 자동으로
	public void search(); // 추상메소드.
	public void delete(); // 추상메소드.
}
