package com.lec.java.variable04;

public class Variable04Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("변수 - char, boolean, String");
		
		//char : 문자 하나를 저장하기 위한 데이터 타입 (2바이트)
		char ch1 = 'A'; //홀따움표
		// char 리터럴은 홀따옴표 ('')로 묶어줌
		// 문자열(String) 리터럴은 쌍따옴표("~")로 묶어줌
		
		System.out.println("ch1 = "+ch1);
		
		char ch2 = '한';//한에 해당하는 정수값이  ch2에 담긴다
		char ch3 = '글';
		System.out.println("ch2 = "+ch2);
		System.out.println("ch3 = "+ch3);// 한글도 출력이 된다
		
		//3-1 PPT (자동 형변환)
		
		char ch4 = 0xAE01;
		System.out.println("ch4 : "+ch4);
		char ch5 = 1234;
		System.out.println("ch5 : "+ch5);

		//println() 은 char를 문자로 출력함
		//그러나 다른 정수형으로 변환 되면 해당 코드값을 정수 로 출력
		char ch6 = '!';
		System.out.println("ch6 : "+ch6);
		
		char ch7 = 33; 						// 코드값에 해당하는 정수를 직접 입력하여 출력이 가능하다.
		System.out.println("ch7 : "+ch7);// ! 출력
		System.out.println("ch7+1 : "+(ch7+1));//34 출력
		System.out.println("ch7+1 : "+(char)(ch7+1));//형변환
		
		char ch8 = 'A';
		char ch9 = 'a';
		System.out.println("'A' :"+ch8+"-"+(int)ch8);
		System.out.println("'a' :"+ch9+"-"+(int)ch9);
		// ASCII 코드
		
		
		//1. 까마귀
		//2. 가마우지
		//3. 직박구리
		//2-  1 - 3
		
		//1. cable
		//2. bible
		//3. able
		//3 - 2 - 1
		
		//1. aaAA
		//2. AaAa
		//3. AAaa
		//4. aAaA
		// 3 - 2 - 4 - 1
		
		//boolean(논리형) : 참(true), 거짓(false)
		
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 : "+b1);
		System.out.println("b2 : "+b2);
		
		System.out.println(10<20);//true출력
		System.out.println(10>20);//flase출력
		
		boolean b3 = (10<20);
		System.out.println("b3 : "+ b3);// true출력
		
		//String 타입 (문자열)
		//primitive타입이 아닙니다!
		String name = "남윤주";// String literal은 "~"
		String nick = "Thunder";
		System.out.println("이름은 : "+ name);
		System.out.println("별명은 : "+ nick);
		
		
		
		
		
	}//end main

}//end class
