package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//ObjectOutputStream은 Serializable을 구현하는 클래스. 
class Emp implements Serializable{
	int id;
	String name;
	String dept;
	
	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "사원id: " + id + ", 이름: " + name + ", 부서 : " + dept ;
	}
}
public class ObjectExample {
	public static void main(String[] args) {
		writeObj();
		try(FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
			ObjectInputStream oos = new ObjectInputStream(fis))
		{
			ArrayList<Emp> list = (ArrayList<Emp>) oos.readObject();
			for(Emp emp: list) {
				System.out.println(emp.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeObj() {

		//입출력 스트림 -> Class 인스턴스 생성 -> 파일입출력.
		// ObjectInputStream, ObjectOutputStream : Object 기반.
		ArrayList<Emp> empList = new ArrayList<>(); // ArrayList에 Emp타입으로 넣어놧음
		empList.add(new Emp(100, "홍길동", "인사"));
		empList.add(new Emp(200, "김민식","개발"));
		empList.add(new Emp(300,"이유진","총무"));
		
		
		try(FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);)
		// try 안에쓰면 close 따로해줄필요가 없음
		{			
			oos.writeObject(empList);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
}
