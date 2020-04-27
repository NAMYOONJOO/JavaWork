package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");

		int count = 1;
		while (count <= 10) {
			System.out.println(count);
			count++; // *위치 중요 sysout보다 위에 있을 시 2~ 11까지 출력된다.
		} // end while

		System.out.println();
		// 10,9,8 ...1까지 출력
		count = 10;
		while (count >= 1) {
			System.out.println(count);
			count--;
		}
		
		//for문은 while 문으로 100% 전환 가능

	} // end main()

} // end class While01Main
