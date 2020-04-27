package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		// 구구단 2단 출력
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 x " + i + " = " + (2 * i));
		}
		System.out.println();
		// 구구단 4단 출력
		for (int i = 1; i <= 9; i++) {
			System.out.println("4 x " + i + " = " + (4 * i));
		}
		// 2 x 2 = 4
		// 3 x 3 = 9
		// ...
		// 9 x 9 = 81
		for (int i = 2; i <= 9; i++) {
			System.out.println(i+" x " + i + " = " + (i * i));
		}
		
		

	} // end main()

} // end class For02Main
