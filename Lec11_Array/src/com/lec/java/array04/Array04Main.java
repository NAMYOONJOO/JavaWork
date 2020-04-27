
package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		System.out.println("점수 입력");
		Scanner sc = new Scanner(System.in);
		int min = 0, max = 0;
		int total = 0;
		int num[] = new int[5];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			total += num[i];

		}
		min = num[0];
		max = num[0];
		for (int j = 1; j < num.length; j++) {// j가 1부터 시작하면 연산횟수를 줄일 수 있다.
			/*
			 * if (num[j] >= max)
			 * 
			 * max = num[j]; if (num[j] <= min) min = num[j];
			 */
			// 삼항연산자
			min = (num[j] < min) ? num[j] : min;
			max = (num[j] > max) ? num[j] : max;
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (double) total / num.length);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	} // end main()

} // end class Array04Main
