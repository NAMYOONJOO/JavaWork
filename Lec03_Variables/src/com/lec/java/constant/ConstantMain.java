package com.lec.java.constant;
/*
 * 상수 : final
 * 변수 선언 앞에 final 키워드를 사용하면
 * '상수 (constant)' 가 되어.
 * 한번 값을 대입하면 변경할수 없게 된다.
 * 
 * 관례적으로 상수값을 담는 상수명은 대문자로 작성
 */


public class ConstantMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myage = 24;
		myage = 40;
		myage = 26;
		
		final int MYAGE = 24;// 한번 초기화가 된다면 변경불과
		//MYAGE = 25// 에러

		final short GRADE1;
		GRADE1 = 100;// 최초초기화 
//		GRADE = 200;// 에러
		// 상수는 보통 변수의 이름을 대문자로 작성한다. 
		// 변수 이름 바꾸기 변수위 우클리-Refactor -Rename (단축키 : alt + shift + s)
	
	
	}

}
