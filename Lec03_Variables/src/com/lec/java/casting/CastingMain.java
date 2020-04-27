package com.lec.java.casting;
/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */
public class CastingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("형변환(Type Casting/Type Converting)");
		
		byte num1 = 123;
		int num2 = 123;
		//byte num3 = num2;//에러 자동형변환이 되지 않는다. (int -> byte)
		byte num3 = (byte)num2; //명시적 형변환 가능
		
		System.out.println("num3 : "+ num3);
		
		//명시적 형변환의 주의점 --> 데이터 손실 발생 주의 
		byte num5 = (byte)513; //이진수로 0010 0000 0001 중 상위바이트가 날라가 0000 0001 만 남는다
		System.out.println("num5 : "+ num5);//1출력
		
		//많이하는 실수 
		double avg1 = (99 + 88 + 78)/3; // int 나누기 int (자동형변환으로 소숫점아래 자리수 날라감)
		System.out.println(" avg1 : "+avg1);
		
		double avg2 = (double)(99 + 88 + 78)/3;
		System.out.println(" avg2 : "+avg2);// 올바른 평균구하기 (하나를 명시적 형변환을 해준다)
		
	}

}
