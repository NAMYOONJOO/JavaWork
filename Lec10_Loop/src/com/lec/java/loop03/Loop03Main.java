package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		// TODO

		for (int i = 2; i <= 9; i++) {
			System.out.println(i+ "단");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " x " + j + " = " + (j * i));
			}
			System.out.println();
			
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		// TODO
		int dan = 2;
		while (dan <= 9) {
			System.out.println(dan+"단");
			int d = 1;
			while (d <= 9) {
				System.out.println(dan + " x " + d + " = " + (dan * d));
				d++;
			}
			dan++;
			System.out.println();
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
