package com.lec.java.final01;

public class Final01Main {
	
	//final 멤버변수
	// 반드시 선언과 동시에 초기화 해야함
	final int NUM =1; //멤버변수, 지역변수의 final 비교 
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		int num1 = 1;
		num1 = 10;
		
		
		final int num2 = 1;
		num1 = 10;
		
		final int num3 ;
		num3 = 1; //final 지역변수는 선언 이후에 초기화 가능!
		
	} // end main()

} // end class Final01Main










