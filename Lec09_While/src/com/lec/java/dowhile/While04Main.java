package com.lec.java.dowhile;
/*
do {
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do ~ while");
		
		int n = 0;
		while (n>0){
			System.out.println("카운트 다운 "+n);
			n--;
		}// 한번도 수행 안되고 끝이 난다. 
		// 이것을 do while로 해볼게요~
		do {
			System.out.println("카운트 다운 "+n);
			n--;
		}while(n>0);
		
		// 구구단 9단을 do while
		
		int i = 1;
		do {
			System.out.println("9 x "+i+" = "+(9*i));
			i++;
		}while(i<=9);
		// "현대 언어에서는 do while이 많이 빠졌습니다~"
	} // end main()

} // end class While04Main









