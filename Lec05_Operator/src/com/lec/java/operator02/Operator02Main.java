package com.lec.java.operator02;

/* 복합 대입 연산자 compound assignment operators
 * 
 * 		+=, -=, *=, /=, %=, ...
 */
public class Operator02Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 2 - 복합 대입 연산자 compound assignment operators");
		System.out.println("+=, -=, *=, /=, %=, ...");
		
		int num1 = 10;
		System.out.println("num1 = "+num1);
		num1 = num1 +1;// 기존 num1값에 1증가
		System.out.println("num1 = "+num1);
		num1 +=1;
		System.out.println("num1 = "+num1);
		
		int num3 = 123;
		num3 -= 23;//num2 = 100;
		System.out.println("num3 ="+ num3);
		
		double num4 = 3.14;
		num4 *= 2;//6.28
		System.out.println("num4 = " +num4);
		
		double num5 = 3.14;
		num5 /=2; //1.57
		System.out.println("num5 = " +num5);
		//* 복학 대입여산은 코딩량을 줄여준다.*
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










