package com.lec.java.array02;

/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");

		int[] korean = new int[3];
		// length : 데이터 개수 --->3
		// size : 데이터 용량 ---> 12 byte (이상)

		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;

		for (int i = 0; i < korean.length; i++) {// 단축키 CTRL+ SPACE
			System.out.println("국어" + korean[i]);
		}

		// 선언과 동시에 초기화

//		int [] english = new int[];//에러 배열의 크기가 안정해져있음
		int[] english = new int[] { 30, 20, 30 };
		// 하지만 요로케 초기화 하면 에러가 나지 않는다.
		for (int i = 0; i < english.length; i++) {
			System.out.println("영어" + i + " : " + english[i]);
		}

		System.out.println();

		// 선언과 동시에 초기화 2
		int[] math = { 99, 88, 77, 66 }; // new int[]{99,88,77,66}
		for (int i = 0; i < math.length; i++) {
			System.out.println("수학" + i + ":" + math[i]);
		}

		int total = 0;
		// 수학점수들의 총점과 평균 계산
		for (int i = 0; i < math.length; i++) {
			total += math[i];
		}
		double avg = (double) total / math.length;
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.1f", avg);

		// 배열을 출력하면 이상한것이 나온당

		// () 괄호
		// {} brace
		// [] bracket

	} // end main()

} // end class Array02Main
