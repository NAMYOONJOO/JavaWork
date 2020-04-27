package com.lec.java.lambda02;

/*	람다 표현식 (lambda - expression): 
	 	() -> 수행코드
	 	() -> 리턴값
	 	(매개변수..) -> 수행코드
	 	(매개변수..) -> 리턴값
	 	
	 매개변수의 타입은 생략해서 표현이 가능
	 매개변수가 여러개 있을 경우,
		 모든 매개변수의 타입을 생략해서 표현하거나,
		 모든 매개변수의 타입을 모두 다 표현해야 함. 
*/
public class Lambda02Main { /// test 1234 : 인터페이스

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");

		// 매개변수 없고, 리턴값도 없는 경우
		Test01 lambda01 = () -> System.out.println("안녕하세요");
		lambda01.testPrint();

		// 매개변수 한개, 리턴값은 없는 경우
		Test02 lambda02 = (x)-> System.out.println("numm :"+x);
		lambda02.testPrint(300);

		// 매개변수 여러개, 리턴값이 있슴.
		Test03 lambda03 = (x,y)-> (x>y)?x:y; //삼항연산자
		System.out.println("result = "+lambda03.max(30, 100));

		// 매개변수 한개, 내부 수행코드 여러줄.., 리턴값.
		Test04 lambda04 = (str) ->{
			System.out.println(str);
			return str.length();//수행코드 두줄이다
		}; //내부코드 여러줄 : {} 묶어주면 된다. 
		System.out.println("result : "+lambda04.myStrLen("윤둥이"));
		
		// Test05 인터페이스 만들기
		// void printMax(double x, double y)
		// [출력양식 예제]
		// x = 3.14
		// y = 1.2
		// 3.14 > 1.2
		Test05 lambda05 = (x,y)->{
			System.out.println("x = "+x);
			System.out.println("y = "+y);
			if(x>y) {
				System.out.println(x+" > "+y);
			}else {
				System.out.println(x+" <= "+y);
			}
		};
		lambda05.printMax(3.14, 1.2);		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
