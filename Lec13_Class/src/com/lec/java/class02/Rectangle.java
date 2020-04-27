package com.lec.java.class02;

public class Rectangle {

	// 속성 : 멤버변수
	// 가로, 세로
	double width;
	double height;

	// 생성자
	// 1. 디폴트 생성자
	public Rectangle() {
		System.out.println("Rectangle() 생성");
		width = 100; // 디폴트값 지정 가능
		height = 100;

		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}

	// 2.매개변수 가진 생성자
	public Rectangle(double w, double h) {
		width = w; // 멤버변수 초기화
		height = h;
		System.out.println("Rectangle(w,h) 생성");
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}

	// 동작 : 멤버 메소드
	// 1) calcPerimeter : 사각형의 둘레
	public double calcPerimeter() {
		return width * 2 + height * 2;
	}

	// 2) clacArea : 사각형의 넓이
	public double calcArea() {
		return width * height;
	}
}
