package com.lec.java.test3;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int day = sc.nextInt();
		
		switch (day) {
		case 0:
			System.out.println("일요일");
			break;
		case 1:
			System.out.println("월요일");
			
			break;
		case 2:
			System.out.println("화요일");
			
			break;
		case 3:
			System.out.println("수요일");
			
			break;
		case 4:
			System.out.println("목요일");
			
			break;
		case 5:
			System.out.println("금요일");
			
			break;
		case 6:
			System.out.println("토요일");
			
			break;

		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		sc.close();
	}

}
