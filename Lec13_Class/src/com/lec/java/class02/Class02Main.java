package com.lec.java.class02;

public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");

		Circle c1 = new Circle(); // *생성자목적 : 인스턴스 생성시 멤버변수들의 초기화
		Circle c2 = new Circle(3);

		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레 :" + perimeter);

		perimeter = c2.calcPerimeter();
		System.out.println("c2의 둘레 :" + perimeter);

		System.out.println("c1의 넓이 : " + c1.calcArea());
		System.out.println("c2의 넓이 : " + c2.calcArea());

		System.out.println();

		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2, 3);

		// r1, r2의 둘레, 넓이 출력
		System.out.println("r1의 둘레 : " + r1.calcPerimeter());
		System.out.println("r2의 둘레 : " + r2.calcPerimeter());

		System.out.println("r1의 넓이 : " + r1.calcArea());
		System.out.println("r2의 넓이 : " + r2.calcArea());

		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main
