package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	
	List<Memo> memoStroage = new ArrayList<>(); // 정보를 당마놓기 위한 컬렉션;
	File file = new File("C:/Temp/memobook.dat");
	Scanner scn = new Scanner(System.in);	
	
	//싱글톤 방식
	private static MemoManager instance = new MemoManager();
	private MemoManager() {
		readFromFile();
	}
	public static MemoManager getInstance() {
		return instance;
	}
	
	// 추가.
	public void inputData() {
		System.out.print("번호 >> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜 >> ");
		String date = scn.nextLine();
		System.out.print("내용 >> ");
		String content = scn.nextLine();
		memoStroage.add(new Memo(no,date, content));		
	}
	public void searchData() {
		System.out.print("날짜 > ");
		String sDate = scn.nextLine();
		boolean exists = false;
		for(int i=0; i<memoStroage.size();i++) {
			if(sDate.equals(memoStroage.get(i).getDate())){
				System.out.println(memoStroage.get(i).toString());
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("해당날짜의 메모가 없습니다");
		}
	}
	//파일을 읽어서 데이터 memoStorage 기능.
	public void readFromFile() {
		//try with resource
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			){
			memoStroage = (List<Memo>)ois.readObject();
		}catch(Exception e) {
//			e.printStackTrace();
			return;
		}
	}
	
	
	public void deleteData() {
		
		System.out.println("번호 >> " );
		try{int no = Integer.parseInt(scn.nextLine());
		for(int i=0; i<memoStroage.size(); i++) {
			if(no==memoStroage.get(i).getNo()) {
				memoStroage.remove(i);
			}
		}
		}catch(NumberFormatException e) {
			System.out.println("번호를 입력하세요!!");
		}
	}
	//종료하면 파일저장
	public void storeToFile() {
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(memoStroage); //파일저장			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}