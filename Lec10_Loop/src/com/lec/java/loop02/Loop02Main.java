package com.lec.java.loop02;

/* continue;
 * 순환문(for, while, do~while) 안에서 continue   를 만나면
 * continue를 감싸는 가장 가까운 순환문 으로 돌아감
 */

public class Loop02Main {

	public static void main(String[] args) {
		System.out.println("continue;");
		
		int num = 1;
		while (num<=10) {
			num++;
			if(num%2==0) continue;
			System.out.println(num); //홀수만 출력
		}
		
		System.out.println();
		// for문과 continue를 사용해서
		// 1 ~ 10 숫자 중 짝수만 출력
		
		for(int i = 1;i<=10;i++) {
			if (i%2==1)continue;
			System.out.println(i);
		}//end for
		
		System.out.println();
		// 2단은 x 2 부터 출력
		// 3단은 x 3 부터 출력
		
		
		
		// TODO



		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















