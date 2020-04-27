package com.lec.java.variable03;
//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double
public class Variable03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("변수-실수타입");
		
		double number1 = 3.141592;//최초의 대입=> 초기화  
		//float number2 = 3.14; : double타입은 float에 대입하지 못한다 
		// 기본적으로 실수 리터럴은  double로 인식
		// float <- double 대입 불가 
		
		//float 리터럴
		float number3 = 3.14f;
		
		// 실수타입 최소, 최대값
		
		System.out.println("float : "+Float.MIN_VALUE+ " ~ "+Float.MAX_VALUE); // float : 1.4E-45 ~ 3.4028235E38
		// 1.4E-45 = 1.45*10의 -45제곱 : 지수 표기법
		System.out.println("double : "+Double.MIN_VALUE+ " ~ "+Double.MAX_VALUE); //double : 4.9E-324 ~ 1.7976931348623157E308
		//실수타입에서 최대 최소 값의 의미 : 소수자리수를 표현할 수 있는가 ?
		
		//실수값은 정확한 값을 기대하면 안된다 -> 정밀도 
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println(number4);
		System.out.println(number5);// 값이 다르게 출력된다 : 정밀도의 차이 
		// float는 정확하게 표현할 수 있는 자리수가 정해져있다
		// float와double은 저장할 수 있는 갑스이 크기만이 아니라
		// 소수점 이하 정밀도 (precision)의 차이가 있다.
		
		//실수 표기법
		double number6=123;//(대입연산자 : 자동 형변환 발생) : 123 -> 123.0
		double number7=1.23e2;//지수표기법(exponential notation)
		System.out.println("number6 = "+number6);
		System.out.println("number7 = "+number7);
		
		double number8 = 0.0001213;
		double number9 = 1.213e-4;
		
		System.out.println("number8 = "+number8);
		System.out.println("number9 = "+number9);
		
	}

}
