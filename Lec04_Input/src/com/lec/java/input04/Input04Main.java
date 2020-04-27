package com.lec.java.input04;

import java.util.Scanner;

//일반적으로 프로그램에서 숫자입력하는 것이 처음에는 '문자열(String)' 형태다
//ex) 웹, 모바일앱..
//
//이를 숫자 타입으로 변환해야 산술 연산등이 가능해진다
//
//Integer.parseInt(문자열)  -->  int 로 변환
//Double.parseDouble(문자열)  --> double 로 변환

//Byte.parseByte(문자열)
//Short.parseShort(문자열)
//Long.parseLong(문자열)
//Float.parseFloat(문자열)
//Boolean.parseBoolean(문자열)

//문자열이 해당 타입으로 변환할수 없는 문자열이면 NumberFormatException 예외 발생 (에러)



public class Input04Main {

	public static void main(String[] args) {
		System.out.println("입력 : 문자열-> 숫자 변환");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 3개 (int, int, int)를 입력받으시오 >");
		String in1 = sc.next();
		int i1 = Integer.parseInt(in1);
		int i2 = Integer.parseInt(sc.next());
		int i3 = Integer.parseInt(sc.next());
		
		System.out.println("i1 , i2, i3 : "+ i1+" "+i2+" "+i3);
		System.out.println("합 : " +(i1+i2+i3));
		
		
		//실수 세개를 문자열로 입력받아서 (next())
		//3 실수의 곱을 구하시오

		System.out.println("실수 3개 (double, double, double)을 입력받으시오>");
		String in2 = sc.next(); //숫자 잘못 입력시 NumberFormatException발생
		// 오류메세지랑 친해지세요~ 에러 발생시 이것이 어떤 에러인지 아는것이 중요하다. 
		double d1 = Double.parseDouble(in2);
		double d2 = Double.parseDouble(sc.next());
		double d3 = Double.parseDouble(sc.next());
		
		System.out.printf("\n%f, %f, %f\n", d1, d2, d3);
		System.out.println("세 수의 곱 : "+ ((double)d1*d2*d3));
		
		
		
		
		
		sc.close();
	}//end main

}//end class
