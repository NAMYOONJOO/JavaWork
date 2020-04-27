package com.lec.java.exception01;

import java.util.Scanner;

/* 예외(Exception)
	
	컴파일 에러 : 문법상 오류
	예외(Exception) : 문법상의 오류 가 아닌 '실행중'*** 에 발생되는 오류상황
	  
	(기본적으로) 예외 가 발생되면, 예외 관련 메세지 출력하고 프로그램이 종료 됩니다.  
 */
public class Exception01Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception)");

		System.out.println("[1] ArithmeticException"); // : / by zero (exception에 대한 메세지)
		int num1 = 123;
		int num2 = 0;
//		System.out.println("num1/num2 = "+(num1/num2));

		System.out.println("[2] ArrayIndexOutOfBoundsException");
		int[] numbers = new int[10];

//		numbers[10] = 100;

		System.out.println("[3] NegativeArraySizeException");

		int size = -1;
//		int [] numbers2 = new int[size];

		System.out.println("[4] NullPointerException");
		String str = null;

//		System.out.println("문자열의 길이 : " +str.length());
		// Null값다음에 절대 . 이 붙을 수 없다.

// aaa= bbb.ccc(ddd[10].eee);
//bbb, ddd, ddd[10]을 확인해야한다. --->. 기준 왼쪽을 의심해볼것

		System.out.println("[5] InputMismatchException");
		Scanner sc = new Scanner(System.in);

		sc.nextInt();// ----> aaa(숫자x) 입력시 에러 발생
		sc.close();

		System.out.println("프로그램 종료");
	} // end main()

} // enc class Exception01Main
