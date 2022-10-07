package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;


public class FriendExe {
	//친구등록 - 학교/회사/일반친구..
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	public void exe() {
		while(true) {
			System.out.println("1.등록 2.조회 3.종료");
			System.out.println("선택 >> ");
			int menu = scn.nextInt();
			if(menu == 1) {
				System.out.println("1.학교친구 2.회사친구 3.일반친구");
				System.out.println("선택 >> ");
				int submenu = scn.nextInt();
				if(submenu == 1 ) {
					addComFriend();
				}else if(submenu == 2) {
					addUnivFriend();
				}else if(submenu == 3) {
					addFriend();
				}
			}
			else if(menu == 2) {
				searchFriend();
			}
			else if(menu == 3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다");
			}
		}
		System.out.println("프로그램 종료.");
	}
	public void addComFriend() {
		System.out.println("이름을 입력하시오");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.println("연락처를 입력하시오");
		String phone = scn.nextLine();
		System.out.println("회사명을 입력하시오");
		String cpny = scn.nextLine();
		System.out.println("부서명을 입력하시오");
		String dept = scn.nextLine();
		ComFriend comf = new ComFriend(name, phone, cpny, dept);
		
		friends.add(comf);
	}
	public void addUnivFriend() {
		scn.nextLine();
		System.out.println("학교친구 이름을 입력하시오");
		String name = scn.nextLine();
		System.out.println("연락처를 입력하시오");
		String phone = scn.nextLine();
		System.out.println("학교를 입력하시오");
		String univ = scn.nextLine();
		System.out.println("전공을 입력하시오");
		String major = scn.nextLine();
		UnivFriend unive = new UnivFriend(name, phone, univ, major);

		friends.add(unive);
	}
	public void addFriend() {
		scn.nextLine();
		System.out.println("이름을 입력하시오");
		String name = scn.nextLine();
		System.out.println("연락처를 입력하시오");
		String phone = scn.nextLine();
		Friend fnd = new Friend(name, phone);
		
		friends.add(fnd);
	}
	
	public void searchFriend() {
		scn.nextLine();
		System.out.println("원하는 성을 입력하시오");
		String name = scn.nextLine();
		
		for(int i=0; i<friends.size(); i++) {
			Object frnd = friends.get(i);
			if(frnd instanceof Friend) { //frnd가 Friend의 인스턴스이면
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;	
				System.out.println(friend.showInfo());	
			}
		
		}
//		for(int i=0; i<friends.size(); i++) {
//			// Friend 클래스의 상속. Friend, Comfriend, UnivFriend의 instatnce
//			Friend frnd = (Friend)friends.get(i);
//			System.out.println(frnd.showInfo());
//		}
			
		
		}
}
