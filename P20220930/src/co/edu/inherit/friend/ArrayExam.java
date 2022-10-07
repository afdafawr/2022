package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {

		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화꽃";
//		flowers[3] = "목련";
		
		String[] flowers2 = new String[6];
		flowers2[0] = "목련";
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		// 배열의 크기 고정 => 컬렉션(ArrayList);
		// Object 모든 클래스의 최상위 클래스.
		ArrayList flowers3 = new ArrayList();
		flowers3.add("장미");
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		
		for(Object str : flowers3) {
			String result = (String) str;
			System.out.println(result);
		}
		for(int i=0; i<flowers3.size(); i++) {
			String result = (String)flowers3.get(i); // 오브젝트타입이니 string으로 형변환
			System.out.println(result);
		}
	}
}