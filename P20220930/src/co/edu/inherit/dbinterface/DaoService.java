package co.edu.inherit.dbinterface;

public interface DaoService {
	//값이 바뀌는 필드선언 할수 없음
	// 추가,수정,삭제,조회
	public void insert();
	public void modify();
	public void remove();
	public void search();
}
