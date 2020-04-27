package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
		// 사용하여 출력해보기
		HashSet<MyClass> hset = new HashSet<MyClass>();
		
		// 데이터 3개 저장
		MyClass mc1 = new MyClass(1, "Abc");
		MyClass mc2 = new MyClass(2, "Def");
		MyClass mc3 = new MyClass(1, "Abc");
		hset.add(mc1);
		hset.add(mc2);
		hset.add(mc3);
		System.out.println("size = " + hset.size());
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = hset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		} // end while
		
		System.out.println();
		System.out.println("enhanced for");
		// TODO			

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class
