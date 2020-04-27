package com.lec.java.variable02;


//자바의 기본 자료형(primitive data type)
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean
// 순서 용량 외우기
public class Variable02Main {

	public static void main(String[] args) {
		
		System.out.println("정수타입 변수들");
		
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ "+Byte.MAX_VALUE); //-128~127
		System.out.println("short : " + Short.MIN_VALUE + " ~ "+Short.MAX_VALUE);//-32768~32767
		
		byte num1 = -128 ;
		byte num2 = 0;
		byte num3 = 123 ;
		//byte num4 = 1234 ; -> -128~127 byte에 저장할 수 있는 크기를 넘어서 에러 발생
		//변수 초기화 : 최초의 값을 대입
		
		short num5 = -12345;
		short num6 = 12345;
		short num7 = 32767;
		//short num8 = 32768; 에러
		//short num9 = -32769; 에러
		
		System.out.println("int : " + Integer.MIN_VALUE + " ~ "+Integer.MAX_VALUE); 
		System.out.println("long : " + Long.MIN_VALUE + " ~ "+Long.MAX_VALUE);
		
		// int num9 = 9876543210; 에러 : 값의 범위를 넘어감
		//long num10 = 9876543210;// 리터럴 변환에서 실패 //The literal 9876543210 of type int is out of range 
		// 리터럴 : literal
		// 직접 코드상에 입력한 값들
		// 정수 리터럴 ---> int로 형변환 하려고 한다
		// 실수  리터럴 ---> double 로 형변환 하려 한다.
		// "~" 리터럴 ---> 문자열 (String)로 형변환
		
		long num11 = 9876543210L; // <--Long 형 리터럴로 인식
		long num12 = 12;
		Long num13 = 12L;
		int num14 = 12;
		//int num 15 = 12L; 에러 : long타입을 int 에 대입 불가 
		//값의 경계선
		byte num15 = Byte.MAX_VALUE;//127
		byte num16 = (byte)(num15 + 1);
		System.out.println("num16 = "+num16);
		
		//--------------------03-17--------------------------
		//정수 표기법
		int number1 = 11;//10진수(Decimal)
		int number2 = 0xB;//16진수 (Hexadecimal), 0x로 시작
		int number3 = 013;//8진수 (Octal), 0으로 시작
		int number4 = 0b1011;//2진수 (Binary), 0b로 시작
		
		System.out.println("number1 = "+ number1);
		System.out.println("number2 = "+ number2);
		System.out.println("number3 = "+ number3);
		System.out.println("number4 = "+ number4);// number1,2,3,4 모두 같은 값을 출력한다. 
		
		//String.format() 을 사용하여 원하는 포맷(진법)으로 출력가능
		System.out.println("number1 = "+ String.format("%x", number1));//16진법으로 출력
		System.out.println("number1 = "+ String.format("%o", number1));//8진법으로 출력
		System.out.println("number1 = "+ number1);
		
		//Integer.toXxx(n) 를 사용하여 원하는 포맷의 문자열로 반환 가능
		System.out.println("number1 = "+ Integer.toHexString(number1));//16진수
		System.out.println("number1 = "+ Integer.toOctalString(number1));//8진수
		System.out.println("number1 = "+ Integer.toBinaryString(number1));//2진수
		
		
		
		
		
		
		
		
	}//end main()

}//end class
