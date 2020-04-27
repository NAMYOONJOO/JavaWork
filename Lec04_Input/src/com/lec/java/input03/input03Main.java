package com.lec.java.input03;

import java.util.Scanner;

public class input03Main {

	public static void main(String[] args) {
		System.out.println("nextLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
		//nextLine()
		System.out.print("여러단어의 문장을 입력 > ");
		String line = sc.nextLine();// \n까지 한 라인 전체 입력
		System.out.println("Line : "+ line); // aaa bbb ccc입력시 모두 출력된다. 
		
		//next()
		//다음 단어(token) 을받아서 String 으로 결과 리턴
		System.out.print("여러단어의 문장을 입력 > ");
		String token1 = sc.next();
		System.out.println("Token1 : "+token1); // aaa bbb ccc 입력시 aaa만 출력된다. 
												// 나머지는 키보드 버퍼에 남게 된다
		String token2 = sc.next();
		System.out.println("Token2 : "+token2); 
		
		String token3 = sc.next();
		System.out.println("Token3 : "+token3); 
		// Next()함수는 앞쪽 띄어쓰기는 버린다. ex ()bbb --> bbb
		// 두 실행결과가 다른것을 확인하기 
		
		// nextInt(), next Double()... <-- next()처럼 동작한다. 
		
		// 따라서 숫자 타입도 여러개를 '한줄'로 입력 받을 수 있다. 
		System.out.println("숫자 3개 (int, double, int)를 입력받으세요 > ");
		int i1 = sc.nextInt();
		double d1 = sc.nextDouble();
		int i2 = sc.nextInt();
		
		System.out.println("i1, d1, i2 : "+i1+" "+d1+" "+i2);
		
		// * 웹/앱 개발시 사용자가 입력하는것은 모두다 문자열이다. 그 후 문자를 숫자로 변형하는 작업이 필요하다. 
		
		
		sc.close();
		
	}//end main

}// end class
