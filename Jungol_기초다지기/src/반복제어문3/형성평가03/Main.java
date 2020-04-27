package 반복제어문3.형성평가03;

import java.util.Scanner;

/*
 * 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cutline = 0;
		int star = sc.nextInt();
		for (int i = 1; i <= (star * 2) + 1; i++) {
			if (i > star) {
				cutline--;
			} else {
				cutline++;
			}
			for (int j = 1; j <= cutline; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

		sc.close();

	}

}
