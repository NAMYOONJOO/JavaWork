package com.lec.java.if04;

/*  삼항 연산자 (ternary operator)
 * 	 (조건식) ? 선택1 : 선택2
 * 	 (조건식)이 true 이면 선택1이 선택되고,
 *   (조건식)이 false 이면 선택2가 선택됨.
 */
public class If04Main {

	public static void main(String[] args) {
		System.out.println("if 문과 삼항 연산자");
		
		System.out.println();
		
		// 두 숫자중 누가 더 큰 숫자인가?
		
		int num1 = 100;
		int num2 = 123;
		
		int big;
		/*
		if (num1>num2) {
			big = num1;
		}else big = num2;
		
		System.out.println("더큰수 : "+big);
		*/
		
		big = num1 > num2 ? num1 : num2	;	
		System.out.println("더 큰수 : "+big );
		
		System.out.println();
		//응용
		//두 수의 차 (difference)
		int num3 = 10;
		int num4 = 20;
		
		int diff;
		
		/*
		 if(num3>num4) {
			diff = num3-num4;
		}else
			diff = num4-num3;
		*/
		//위의 if 구문과 아래의 삼항 연산자가 같은 기능을 한다. 
		
		diff= num3>num4?num3-num4:num4-num3;
		
		System.out.println("두수의 차 : "+ diff);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










