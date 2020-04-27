package com.lec.java.method09;

/*  Call By Value : 값에 의한 호출
 	Call By Reference : 참조에 의한 호출
 	
 	메소드 호출시 매개변수에 넘겨주는 값의 '복사' 가 발생.
 	
 	자바에선
 	primitive type 이 매개변수 인 경우 Call By Value
 	 		: '값' 이 복사된다 
 	 		: 메소드에서 매개변수 값을 변경해도 호출한 원본 쪽은 변화 없슴
 	 		
 	reference type 이 매개변수 인 경우 Call By Reference 발생
 			: '주소' 가 복사된다.
 			: 메소드에서 매개변수 를 통해 변경하면 호출한 원본 쪽도 변화 발생
 	
 */
public class Method09Main {

	public static void main(String[] args) {
		System.out.println("Call By Value : 값에 의한 호출");
		System.out.println("Call By Reference : 참조에 의한 호출");

		int n = 10;
		incNum(n);
		System.out.println("incNum(int) 호출 후n : " + n);
		System.out.println();
		int[] arr = { 10 };
		incNum(arr);
		System.out.println("incNum(int[]) 호출 후n : " + arr[0]);
		// 위 두 실행결과가 다르다 .
		// 두 실행결과 둘다 사본이 생기는것은 같으나 reference 타입은 주소가 복사되고
		// premitive타입은 값의 사본이 생기기 때문에 값이 변하지 않는다

		System.out.println("\n프로그램 종료");
	} // end main()

	public static void incNum(int value) {
		value++;
		System.out.println("incNum(int): " + value);
	}

	public static void incNum(int[] arr) {
		arr[0]++;
		System.out.println("incNum(int[]) : " + arr[0]);

	}

} // end class
