package com.lec.java.test1;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("두 수를 입력하세요");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		
		System.out.printf("두수의 합 : %.1f\n",(double)(num1+num2));
		System.out.printf("두수의 곱 : %.1f\n",(double)num1*num2);
		
		sc.close();
		
		
	}


}
