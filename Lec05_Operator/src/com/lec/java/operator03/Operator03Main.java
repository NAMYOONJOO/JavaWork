package com.lec.java.operator03;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
public class Operator03Main {

	public static void main(String[] args) {
		System.out.println("연산자 3 - 부호연산자(+, -) sign operator");

		int num1 = -10;// 연산자가 몇개에요 ~? : 2개 (부호 연산자, 대입연산자)
		int num2 = +num1;// 부호는 바뀌지 않는다.
		int num3 = -num1;

		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);

		int num4 = 11;
		int num5 = -22;
		int num6 = num4 + -num5;// 33 // 연산자 3개
		System.out.println("num6 = " + num6);

		int num7 = num4 - -num5;// -11// 띄어쓰기를 하지 않으면 에러가 발생한다. (--)연산이 따로존재한다.
		// * ■ 관례적으로 이항연산자는 피연산자와 연산자 간에 한칸씩(space) 띄어주는게 좋다
		// * 단항연산자는 피연산자와 연산자를 붙여주는게 일반.
		// 이를 깔끔하게 해주는 이클립스의 기능 : 메뉴source-Format >>> Source Fomating (단축키 CTRL SHIFT F)
		// )

		System.out.println("num7 = " + num7);

		System.out.println("\n프로그램 종료");
	} // end main

} // end class
