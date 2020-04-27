package com.lec.java.test2;

import java.util.Scanner;
//Hello World
//
//perfect
//
//JavaException
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 세개를 입력하세요");
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		
		System.out.print(str1.charAt(0));
		System.out.print(str2.charAt(0));
		System.out.print(str3.charAt(0));
		

	}

}
