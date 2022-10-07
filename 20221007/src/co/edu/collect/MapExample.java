package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		//key : Integer, val: String
		//키값중복안됨
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100,"홍길동");
		map.put(200,"김기영");
		map.put(300,"박문식");
		map.put(300,"박문식");
		
		map.remove(200);
		System.out.println("컬렉션: " + map.size());
		System.out.println("val: " + map.get(300));
		
		Set<Integer> keySet =map.keySet();
		for(Integer key : keySet) {
			System.out.println("키: " + key + ", 값" + keySet);
		}
		Set<Entry<Integer,String>> entSet = map.entrySet();
		for(Entry<Integer,String> ent: entSet) {
		System.out.println("키 : " + ent.getKey() 
							+ " 값 : "+ent.getValue());
		}
	}
}