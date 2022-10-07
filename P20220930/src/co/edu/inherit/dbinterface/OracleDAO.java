package co.edu.inherit.dbinterface;
// 구현클래스명 implements 인터페이스명
public class OracleDAO implements DaoService{ 

	@Override
	public void insert() {
		System.out.println("oracle 저장.");
	}

	@Override
	public void modify() {
		System.out.println("oracle 변경.");
	}

	@Override
	public void remove() {
		System.out.println("oracle 삭제.");
	}

	@Override
	public void search() {
		System.out.println("oracle 조회.");
	}
	
//	public void add() {
//		System.out.println("oracle 저장.");
//	}
//	public void modify() {
//		System.out.println("oracle 변경.");		
//	}
//	public void find() {
//		System.out.println("oracle 조회.");
//	}
//	public void remove() {
//		System.out.println("oracle 삭제.");		
//	}
}
