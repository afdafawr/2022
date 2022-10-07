package co.edu.emp;

import java.util.ArrayList;

public class ListApp {
	public static void main(String[] args) {
	//	배열 -> 컬렉션(ArrayList, HashSet, HashMap)
		String[] strAry = new String[10];
		// Object <- 모든클래스
		//기본적으로 오브젝트로 만들어짐
//		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("Employee");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
//		list.set(index,String) 인덱스값을 고침
		
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		intList.add(300);
		ArrayList<Employee> emplist = new ArrayList<Employee>();//employee 클래스 타입만
		
		emplist.add(new Employee(100,"홍길동",1000));
		emplist.add(new Employee(200,"김민수",2000));
		emplist.add(new Employee(300,"박인기",3000));
		emplist.add(new Employee(400,"황석용",4000));
		
		String result = null;
		int salary = 0;
		for(int i=0; i<emplist.size(); i++){
			if(emplist.get(i).getEmployeeId() == 200) {
				result = emplist.get(i).getName();
				salary = emplist.get(i).getSalary();
			}
		}
		System.out.println("이름은 "  + result + " 급여는 " + salary +"입니다");
	}
}
