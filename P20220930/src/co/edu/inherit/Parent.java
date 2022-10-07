package co.edu.inherit;

public class Parent extends Object{//Object = 모든 오브젝트중 최상위오버젝트, 디폴트 Object를 가짐 
	String field;
	Parent(){
		System.out.println("Parent() call.");
	}
	Parent(String args){
		System.out.println("Parent(String args) call.");
	}
	@Override
	public String toString() {// toString이라는 함수가 Object 내에 들어있기때문에 가능
		return "Parent [field=" + field + "]";
	}
	void method() {
		System.out.println("parent method() call.");
	}
}