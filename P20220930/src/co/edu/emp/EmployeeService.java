package co.edu.emp;

//기능을 저장 배열,컬렉션 기능 crud
public interface EmployeeService {
	public void init(); //초기화
	public void input(); //추가
	public String search(int employeeId); //사원아이디에 이름 반환.
	public void print(); // 전체사원정보 출력.
	public int searchSal(int employeeID);
}
