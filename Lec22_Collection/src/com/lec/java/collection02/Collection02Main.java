package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("hello");
		list.add("my");
		list.add("name");
		list.add("are");
		list.add("yoon joo Princss");
		
		list.set(3, "is");
		list.remove(0);
		
		System.out.println();
		//for을 이용한 출력
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		//Enhanced-for
		for(String e : list) {
			System.out.println(e);
		}
		
		System.out.println();
		//Iterator
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
			
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












