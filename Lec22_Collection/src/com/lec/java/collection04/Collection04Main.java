package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection04Main {
	// TODO
			// MemberModel 타입을 담는 ArrayList를 만드고
			// 사용자로부터 3개의 Student 데이터 을 입력받아서
			//        (id, passwd)
			// 3가지 방법으로 출력해보세요. 
			// for, Enhanced-for, Iterator
	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		ArrayList<MemberModel> member = new ArrayList<MemberModel>();
		
		Scanner sc = new Scanner(System.in);
		for(int i= 0; i<2;i++) {
			System.out.println("id : ");
			String id = sc.next();
			System.out.println("pw : ");
			String pw = sc.next();
			MemberModel member1 = new MemberModel(id,pw);
			member.add(member1);
		}
		sc.close();
		for(MemberModel e: member) {
			e.displayInfo();
		}
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












