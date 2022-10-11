package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		//임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고 ..
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = randomWords(3);
		for(String word : words)
			System.out.println(word);
		
		boolean check = false;
		while(true) {
			System.out.println("생성된 문장을 지워봅시다");
			String del = scn.nextLine();
			
			for(int i=0; i<words.size(); i++) {
				if(words.get(i).equals(del)) {
					words.remove(i);
				}
			}
			for (String str : words) {
					System.out.println(str);
			}
			if(words.isEmpty()) {
				break;
			}
		}
		System.out.println("종료되었습니다.");
		}
		
	public static ArrayList<String> randomWords(int times) throws Exception{
		//ArrayList<String> 전체 문장을 담고..
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt";
		File file = new File(path);
		Scanner scn = new Scanner(file);
		while(scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim();
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}
		//임의의 갯수 times의 개수마큼을 반환하도록
		ArrayList<String> randomWords = new ArrayList<String>();
		
		//중복값 제거하기 위해 Set 컬렉션 사용하여 저장
		Set<Integer> idxSet = new HashSet<>();
		while(idxSet.size()<times) {
			idxSet.add((int)(Math.random()*words.size()));
		}

		for(int idx:idxSet) {
			randomWords.add(words.get(idx));
		}
		scn.close();
		return randomWords;
	}
}
