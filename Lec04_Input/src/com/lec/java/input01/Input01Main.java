package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준 입력 (Standard Input) : 키보드로부터 입력
 * 			Scanner 객체 사용
 * 
 * 표준 출력 (Standard Output) : 모니터로 출력
 */
public class Input01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("표준입력 : Scanner 사용");
		Scanner sc= new Scanner(System.in);//import 필요, Scanner객체 생성//import java.util.Scanner; Scanner라는 클래스를 지금부터 사용하겠습니다를 상단에 표시 
		
		//Scanner 사용한 입력 작업
		int num1, num2;
		System.out.print("숫자 1을 입력하세요 :  ");
		num1 = sc.nextInt();
		System.out.print("숫자 2을 입력하세요 :  ");
		num2 = sc.nextInt();
		// nextInt() 에서 문자나 다른걸 입력하면 InputMismatchException 발생
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
// 		char 입력하는 메소드는 없습니다. (다른방법있음)
		
		
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2); // 위의 줄과 같은 결과를 출력한다. 
		
		sc.close();//Scanner 객체를 사용한 뒤에는 반드시 close()를 해주자.
		

	
	
	
	}

}
