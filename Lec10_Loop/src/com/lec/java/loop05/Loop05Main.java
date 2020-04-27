package com.lec.java.loop05;

public class Loop05Main {

	public static void main(String[] args) {
		System.out.println("순환문 연습 - 언제 100을 넘나?\n");
		// 1 + (-2) + 3 + (-4) + ...+ (n) >= 100 ?
		// 언제(n) 합이 100을 넘나? 그 합은?
		int cnt = 0;
		int i = 1;
		for (int num = 1;; num++) {
			cnt = cnt + (i * num);
			i = i * (-1);
			if (cnt >= 100) {
				System.out.println("n값 : " + num + "\n합 : " + cnt);
				break;
			}

		}

		System.out.println("\n순환문 연습 - 두 주사위 눈의 합\n");

		// 두주사이의 합이 6

		for (int x = 1; x <= 6; x++) {
			for (int y = 1; y <= 6; y++) {
				if (x + y == 6) {
					System.out.println("(" + x + "," + y + ")\n");
				}
			}
		}

	} // end main()

} // end class
