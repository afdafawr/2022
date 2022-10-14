package co.edu.nested;
import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;


public class FuntionalExample {
	public static void main(String[] args) {
		 //매개값(String)은 잇지만 반환값(void)는 없다
		Consumer<String> consumer = t->System.out.println(t + "는 흥미롭다.");
		consumer.accept("자바");
		
		// 함수적 프로그래밍 -> 데이터 처리.
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search();
		
		//list의 데이터가 흘러간다..
		list.stream().forEach((t) -> System.out.println(t.toString()));
	}
}
