package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		TreeSet<String> tset = new TreeSet<String>();
		
		//저장
		tset.add("안녕");
		tset.add("우경아");
		tset.add("몬생인 우경아");
		tset.add("배고픈가혹시");
		tset.add("더웡");
		//오름차순 출력
		System.out.println();
		System.out.println("오름차순");
		System.out.println();
		Iterator<String> itr = tset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//내림차순 출력
		System.out.println();
		System.out.println("내림차순");
		System.out.println();
		itr = tset.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















