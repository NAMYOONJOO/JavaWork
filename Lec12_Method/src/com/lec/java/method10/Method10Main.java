package com.lec.java.method10;

import java.util.Arrays;
import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 */
public class Method10Main {

	public static void main(String[] args) {
		System.out.println("메소드와 배열");
		Scanner sc = new Scanner(System.in);

		int[] score = new int[10];
		// 점수를 입력받아서 score배열에 저장
		inputScore(sc, score);
		// 저장된 점수확인
		displayScore(score);
		System.out.println();
		// 총점계산
		int total = calcTotal(score);
		System.out.println("점수총점 : " + total);

		sc.close();

		System.out.println("랜덤 숫자 배열 생성");
		double[] randArr = genRandom(10);
		System.out.println(Arrays.toString(randArr));
		
		
		int min = fidmMin(score);
		int max = fidmMax(score);
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
		System.out.println("\n프로그램 종료");
	} // end main()
 
	// method name: inputScore
	// return: void
	// arguments:
	// 1) Scanner sc - 입력장치
	// 2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] Score) {
		for (int i = 0; i < Score.length; i++) {
			System.out.println("점수입력");
			Score[i] = sc.nextInt();
		}

	}

	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	public static void displayScore(int[] score) {
		System.out.println("점수출력\n=============================");
		for (int x : score) {
			System.out.print(x + ",");
		}
		System.out.println("\n====================================");

	}

	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	public static int calcTotal(int[] score) {
		int total = 0;
		for (int x : score) {
			total += x;
		}
		return total;
	}

	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	public static int fidmMax(int[] score) {
		int max = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] > max)
				max = score[i];
		}

		return max;
	}

	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	public static int fidmMin(int[] score) {
		int min = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] < min)
				min = score[i];
		}

		return min;
	}

	// method name: genRandom()
	// return: double[] (생성된 난수 배열)
	// arguments: n 생성할 난수 개수
	public static double[] genRandom(int n) {
		double[] arr = new double[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= Math.random();//난수발생
		}
		return arr;
	}

} // end class Method09Main
